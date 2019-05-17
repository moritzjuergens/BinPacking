package DefaultPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WorkerNormal implements Worker {

	private static List<Bin> bins = new ArrayList<Bin>();
	
	public void insertElement(int element) {
    	Bin.validateElement(element);
        boolean success = false;
        for (Bin bin : bins) {
            if (bin.addElement(element)) {
                success = true;
                break;
            }
        }
        if (!success) {
            bins.add(new Bin());
            bins.get(bins.size()-1).addElement(element);
        }
    }
    
    public String[][] getDisplayData() {
        String[][] data = new String[bins.size()][2];

        for (int i = 0; i < bins.size(); i++) {
            data[i][0] = String.valueOf(i + 1);
            data[i][1] = getElements(bins.get(i));
        }
        
    	return data;
    }

	private static String getElements(Bin bin) {
		StringJoiner stringJoiner = new StringJoiner(", ");
		
        for (int element: bin.getElements()) {
        	stringJoiner.add(String.valueOf(element));
        }

		return stringJoiner.toString();
	}
	
}
