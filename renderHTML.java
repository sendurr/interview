/*
QUESTION #2:
//
// The following Java code is responsible for creating an HTML "SELECT"
// list of U.S. states, allowing a user to specify his or her state. This might
// be used, for instance, on a credit card transaction screen.
//
// Please rewrite this code to be "better". Submit your replacement code, and
// please also submit a few brief comments explaining why you think your code
// is better than the sample.
//
// (For brevity, this sample works for only 5 states. The real version would
// need to work for all 50 states. But it is fine if your rewrite shows only
// the 5 states here.)
//
public class StateUtils {
    //
    // Generates an HTML select list that can be used to select a specific
    // U.S. state.
    //
    public static String createStateSelectList()
    {
        return
                "<select name=\"state\">\n"
                        + "<option value=\"Alabama\">Alabama</option>\n"
                        + "<option value=\"Alaska\">Alaska</option>\n"
                        + "<option value=\"Arizona\">Arizona</option>\n"
                        + "<option value=\"Arkansas\">Arkansas</option>\n"
                        + "<option value=\"California\">California</option>\n"
                        // more states here
                        + "</select>\n"
                ;
    }
    //
    // Parses the state from an HTML form submission, converting it to
    // the two-letter abbreviation.
    //
    public static String parseSelectedState(String s)
    {
        if (s.equals("Alabama"))     { return "AL"; }
        if (s.equals("Alaska"))      { return "AK"; }
        if (s.equals("Arizona"))     { return "AZ"; }
        if (s.equals("Arkansas"))    { return "AR"; }
        if (s.equals("California"))  { return "CA"; }
        // more states here
    }
    //
    // Displays the full name of the state specified by the two-letter code.
    //
    public static String displayStateFullName(String abbr) {
        {
            if (abbr.equals("AL")) { return "Alabama";    }
            if (abbr.equals("AK")) { return "Alaska";     }
            if (abbr.equals("AZ")) { return "Arizona";    }
            if (abbr.equals("AR")) { return "Arkansas";   }
            if (abbr.equals("CA")) { return "California"; }
            // more states here
        }
    }*/
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

class StateUtils{
	public static HashMap<String, String> stateMap = new HashMap<String, String>();
	
	StateUtils(){
		//Dummy;
	}
	
	StateUtils(String[][] state){
		importState(state);
	}
	
	public static void importState(String[][] state){
		int i;
		for(i=0;i<state.length;i++){
			stateMap.put(state[i][1], state[i][0]);
		}
	}

    public static String parseSelectedState(String s)
    {
    	if(stateMap.containsValue(s)){
    		Set<Map.Entry<String, String>> mapping = stateMap.entrySet();
    		for(Map.Entry<String, String> entry: mapping){
    			if(entry.getValue()==s){
    				return (String)entry.getKey();
    			}
    		}
    		return "-1";
    	}else{
    		return "-1";
    	}
    }

    public static String displayStateFullName(String abbr){
    	if(stateMap.containsKey(abbr)){
    		return stateMap.get(abbr);
    	}else{
    		return "-1";
    	}
    }

    public static String createStateSelectList()
    {
    	StringBuilder htmlBlock = new StringBuilder();
    	htmlBlock.append("<select name=\"state\">\n");
    	Set<Map.Entry<String, String>> mapping = stateMap.entrySet();
    	for(Map.Entry<String, String> entry: mapping){
    		htmlBlock.append("<option value=\""+entry.getValue()+"\">"+entry.getValue()+"</option>\n");
    	}
    	htmlBlock.append("</select>\n");
        return
                "<select name=\"state\">\n"
                        + "<option value=\"Alabama\">Alabama</option>\n"
                        + "<option value=\"Alaska\">Alaska</option>\n"
                        + "<option value=\"Arizona\">Arizona</option>\n"
                        + "<option value=\"Arkansas\">Arkansas</option>\n"
                        + "<option value=\"California\">California</option>\n"
                        // more states here
                        + "</select>\n"
                ;
    }
	
    public void processReq(int html, String s, String abbr){
    	if(html==1){
    		System.out.println(createStateSelectList());	
    	}
    	System.out.println(displayStateFullName(abbr));
    	System.out.println(parseSelectedState(s));
    }
}
public class renderHTML {

	public static void main(String[] args) {
		String [][] entries = {{"Alabama", "AL"},
        {"Alaska", "AK"},
        {"Arizona", "AZ"},
        {"Arkansas", "AR"},
        {"California", "CA"}};
		StateUtils state = new StateUtils(entries);
		state.processReq(1, "Alabama", "CA");

	}

}
