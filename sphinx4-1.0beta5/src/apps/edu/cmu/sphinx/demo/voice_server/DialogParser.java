package edu.cmu.sphinx.demo.voice_server;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.jvoicexml.xml.Text;
import org.jvoicexml.xml.XmlNode;
import org.jvoicexml.xml.XmlNodeFactory;
import org.jvoicexml.xml.srgs.Grammar;
import org.jvoicexml.xml.srgs.Item;
import org.jvoicexml.xml.srgs.Rule;
import org.jvoicexml.xml.vxml.Field;
import org.jvoicexml.xml.vxml.Form;
import org.jvoicexml.xml.vxml.If;
import org.jvoicexml.xml.vxml.Value;
import org.jvoicexml.xml.vxml.VoiceXmlDocument;
import org.jvoicexml.xml.vxml.Vxml;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class Voice {
	public static void say(String s) {

	}
}

class Input {
	public static String get() {
		return "";
	}

	public static int pickFromChoices(ArrayList<String> choices, String input) {
		// given a list of choices return the index of the string that matches
		// the input
		// if not found return -1
		for(int i = 0; i < choices.size(); i++)
			if(choices.get(i).equalsIgnoreCase(input))
				return i;
		return -1;
	}
}

public class DialogParser {

	static HashMap<String, String> variables;

	public static void parse() throws Exception {
		VoiceXmlDocument document = new VoiceXmlDocument(new InputSource(
				"src/apps/edu/cmu/sphinx/demo/voice_server/dialog1.vxml"));
		Vxml root = document.getVxml();
		Form form = root.getForms().get(0);
		String s = form.getFirstLevelTextContent();
		NodeList b = form.getChildNodes();
		for (int i = 0; i < b.getLength(); i++) {
			Node n = b.item(i);
			s = n.getNodeName();
			if (n.getNodeName().equals("block")) {
				Voice.say(n.getTextContent());
			} else if (n.getNodeName().equals("field")) {
				handleField((Field) n, document.getXmlNodefactory());
			}

		}

	}

	private static void handleField(Field field,
			XmlNodeFactory<?> xmlNodeFactory) {
		String varname = field.getName();
		Collection<XmlNode> children = field.getChildren();
		String input = "";
		String prompt = "";
		for (XmlNode n : children) {
			if (n.getNodeName().equals("prompt")) {
				for (XmlNode var : n.getChildren()) {
					if (var.getNodeName().equals("value")) {
						Value expression = (Value) var;
						Text replacedText = new Text(var.getNode(),
								xmlNodeFactory);
						// replacedText.setTextContent(variables.get(expression
						// .getExpr()));
						n.replaceChild(var, replacedText);
					}
				}
				prompt = n.getTextContent();
			} else if (n.getNodeName().equals("grammar")) {
				Grammar g = (Grammar) n;
				Rule rule = g.getRootRule();
				ArrayList<String> choices = new ArrayList<>();
				ArrayList<String> taglist = new ArrayList<>();

				for (XmlNode type : rule.getChildren()) {
					if (type.getNodeName().equals("one-of")) {
						for (XmlNode child : type.getChildren()) {
							if (child.getNodeName().equals("item")) {
								Item item = (Item) child;
								XmlNode[] t = item.getChildren().toArray(
										new XmlNode[0]);
								choices.add(t[0].getTextContent());
								taglist.add(t[1].getTextContent());
							}
						}
					}
				}
				while (true) {
					Voice.say(prompt);
					input = Input.get();
					int index = Input.pickFromChoices(choices, input);
					if (index != -1) {
						setVariable(varname, taglist.get(index));
						break;
					}
					Voice.say("I couldnt get what you said.");
				}
			} else if (n.getNodeName().equals("filled")) {
				String s = n.getTextContent().replaceAll("\\s", "");
				if (!s.equals("")) {
					Voice.say(s);
				} else {
					for (XmlNode node : n.getChildren()) {
						if (node instanceof If) {
							If ifNode = (If) node;
							String condition = ifNode.getCond();
							if (statisfiesCondition(condition)) {

							}
						}
					}
				}
			}
		}

	}

	private static boolean statisfiesCondition(String condition) {
		// get a condition statement in the form of "variable" or "!variable" and
		// check whether the value of the variable is true or false accordingly
		boolean b = variables.get(condition.replaceFirst("[!]", "")).equalsIgnoreCase("true") ? true : false;
		return condition.startsWith("!") ? !b : b;
	}

	private static void setVariable(String variable, String tag_text) {
		// This method should parse the tag text given and set the correct
		// value in the hashmap.
		String parsed_tag_text = tag_text.replaceFirst("([$][=][']|[$][=])", "");
		parsed_tag_text = parsed_tag_text.endsWith("';") ? parsed_tag_text.substring(0, parsed_tag_text.length() -2) : parsed_tag_text.substring(0, parsed_tag_text.length() - 1);
		variables.put(variable, parsed_tag_text);
	}

	public static void main(String[] args) throws Exception {
		parse();
	}

}