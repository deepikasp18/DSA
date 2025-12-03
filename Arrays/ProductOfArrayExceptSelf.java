public  class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4};
        int[] result = productExceptSelf(array);
        System.out.println("Product of Array Except Self:");
        for (int prod : result) {
            System.out.print(prod + " ");
        }
    }

    public static int[] productExceptSelf(int[] array) {
        int n = array.length;
        int[] result = new int[n];

        int zerosCount = 0;
        int idxOfZero = -1;
        int totalProduct = 1;

        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                zerosCount++;
                idxOfZero = i;
            } else {
                totalProduct *= array[i];
            }
        }

        if (zerosCount > 1) {
            return result; // All elements will be zero
        } else if (zerosCount == 1) {
            result[idxOfZero] = totalProduct;
            return result;
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = totalProduct / array[i];
            }
            return result;
        }
    }
}