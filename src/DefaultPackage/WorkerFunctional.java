package DefaultPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WorkerFunctional implements Worker {
	private static List<Bin> bins = new ArrayList<Bin>();
	
	public void insertElement(int element) {
    	Bin.validateElement(element);
    	
    	bins.stream()
            .filter(b -> b.calculateFreeSpace() >= element)
            .findFirst()
            .orElseGet(() -> {
                bins.add(new Bin());
                return bins.get(bins.size()-1);
            })
            .addElement(element);
    }
    
    public String[][] getDisplayData() {
        String[][] data = new String[bins.size()][2];
        
        bins.stream()
        	.forEach(b -> {
        		data[bins.indexOf(b)][0] = String.valueOf(bins.indexOf(b) + 1);
        		data[bins.indexOf(b)][1] = getElements(b);
        	});
        
    	return data;
    }

	private static String getElements(Bin bin) {
		StringJoiner stringJoiner = new StringJoiner(", ");
		
		bin.getElements()
			.stream()
			.forEach(e -> {
				stringJoiner.add(String.valueOf(e));
			});
		
		return stringJoiner.toString();
	}
}
