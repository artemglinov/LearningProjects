public class FlourPacker {



    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int count = smallCount;

        if (goal > 5 * bigCount + smallCount) {
                return false;
            } else if(goal <= smallCount){
                return true;
            } else {
            while (bigCount > 0) {
                smallCount = count;
                while (smallCount >= 0) {

                    if (goal == 5 * bigCount + smallCount) {
                        return true;
                    }
                    smallCount--;

                }
                bigCount--;
            }

            return false;
        }
    }
}

