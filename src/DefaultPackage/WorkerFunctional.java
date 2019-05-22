package DefaultPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WorkerFunctional implements Worker {
	private static List<Bin> bins = new ArrayList<Bin>();

	//See WorkerNormal to know what method does what
	//In this class only the functional parts will be commented

	public void insertElement(int element) {
    	Bin.validateElement(element);

    	//stream all the bins (= foreach through the Bins)
    	bins.stream()
				//filter the bins where the given element can be added
            .filter(b -> b.calculateFreeSpace() >= element)
				//if there are bins, where the element can be added, return the first one
            .findFirst()
				//if there aren't any bins to add the Element into, create a new one
            .orElseGet(() -> {
            	//create new bin
                bins.add(new Bin());
                //return this new bin
                return bins.get(bins.size()-1);
            })
				//add the Element to the returned Bin
            .addElement(element);
    }
    
    public String[][] getDisplayData() {
        String[][] data = new String[bins.size()][2];

        //Does the same thing as the corresponding method in class WorkerNormal, just with functional implementation
        bins.stream()
        	.forEach(b -> {
        		data[bins.indexOf(b)][0] = String.valueOf(bins.indexOf(b) + 1);
        		data[bins.indexOf(b)][1] = getElements(b);
        	});
        
    	return data;
    }

	private static String getElements(Bin bin) {
		StringJoiner stringJoiner = new StringJoiner(", ");

		//Adds the elements to the StringJoiner with .stream
		bin.getElements()
			.stream()
			.forEach(e -> {
				stringJoiner.add(String.valueOf(e));
			});
		
		return stringJoiner.toString();
	}
}
