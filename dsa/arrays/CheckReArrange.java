// Re-arrange Positive & Negative Values

class CheckReArrange {

    //Re-Arrange Positive and Negative Values of Given Array 
    public static void reArrange(int arr[]) {
  
      int[] newArray = new int[arr.length];
      int newArrayIndex = 0;
  
      //Fill newArray with Negative Values first.
      //Then fill it with postive values.
      //In the end, insert every element of newArray back into original arr.
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] < 0)
          newArray[newArrayIndex++] = arr[i];
      }
  
      for (int i = 0; i < arr.length; i++) {
  
        if (arr[i] >= 0)
          newArray[newArrayIndex++] = arr[i];
      }
  
      for (int j = 0; j < newArrayIndex; j++) {
        arr[j] = newArray[j];
      }
    }
  
    public static void main(String args[]) {
      
      int[] arr = {2, 4, -6, 8, -5, -10};
  
      System.out.print("Array before re-arranging: ");
      for(int i = 0; i < arr.length; i++)
        System.out.print(arr[i] + " ");
      System.out.println();
  
      reArrange(arr);
  
      System.out.print("Array after rearranging: ");
      for(int i = 0; i < arr.length; i++)
        System.out.print(arr[i] + " ");
    }
  }
