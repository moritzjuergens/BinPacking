package DefaultPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WorkerFunctional implements Worker {
	private static List<Bin> bins = new ArrayList<Bin>();

	//See WorkerNormal to know what Method does what
	//Here will only the functional Code be commented

	public void insertElement(int element) {
    	Bin.validateElement(element);

    	//stream all the bins = foreach through the Bins
    	bins.stream()
				//filter the bins who can add the given Element
            .filter(b -> b.calculateFreeSpace() >= element)
				//if there are Bin who can add the Element, return the first one
            .findFirst()
				//if there is none to add the Element into, create a new one
            .orElseGet(() -> {
            	//create new Bin
                bins.add(new Bin());
                //return this new Bin
                return bins.get(bins.size()-1);
            })
				//add the Element to the returned Bin
            .addElement(element);
    }
    
    public String[][] getDisplayData() {
        String[][] data = new String[bins.size()][2];

        //Basically Does the same thing as the normal Method, just functional
        bins.stream()
        	.forEach(b -> {
        		data[bins.indexOf(b)][0] = String.valueOf(bins.indexOf(b) + 1);
        		data[bins.indexOf(b)][1] = getElements(b);
        	});
        
    	return data;
    }

	private static String getElements(Bin bin) {
		StringJoiner stringJoiner = new StringJoiner(", ");

		//Adds the Elements to the StringJoiner with .stream
		bin.getElements()
			.stream()
			.forEach(e -> {
				stringJoiner.add(String.valueOf(e));
			});
		
		return stringJoiner.toString();
	}
}
