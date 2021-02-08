package myPackage;
public interface Search
{
    int searchInt(int[] array, int key);
}
class SimplestSearch implements Search {
	@Override
	public int searchInt(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i]==key) {
				return i;
			}
		}
		return -1;
	}
}
class BinarySearch implements Search{ 
    // Returns index of x if it is present in arr[l.. 
    // r], else return -1 
	@Override
    public int searchInt(int[] array, int key){
    	return binarySearch(array, key, 0, array.length-1);
    }
    
	public int binarySearch(int[] sortedArray, int key, int low, int high) {
	    int middle = (low + high) / 2;
	    if (high < low) 
	        return -1;
	    if (key == sortedArray[middle]) 
	        return middle;
	    else if (key < sortedArray[middle]) 
	        return binarySearch(sortedArray, key, low, middle - 1);
	    else 
	        return binarySearch(sortedArray, key, middle + 1, high);
	}
}