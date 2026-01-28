package greedy;

/*
You are given a lock which is made up of n-different circular rings and
each ring has 0-9 digit printed serially on it. Initially all n-rings together
show a n-digit integer but there is particular code only which can open the lock.
You can rotate each ring any number of time in either direction.
You have to find the minimum number of rotation done on rings of lock to open the lock.
 */
public class MinRotationsForCircularLock {
    public static void main(String[] args) {
        int initialLock = 1932;
        int unlockCode = 5432;

        int minRotations = minRotations(initialLock, unlockCode);
        System.out.println("Min rotations done to open the lock: %d".formatted(minRotations));
    }

    private static int minRotations(int initialLock, int unlockCode) {
        int rotations = 0;
        int lockDigit = 0;
        int codeDigit = 0;
        while (initialLock > 0) {
            lockDigit = initialLock % 10;
            codeDigit = unlockCode % 10;

            int absDiff = Math.abs(lockDigit - codeDigit);
            rotations += Math.min(absDiff, 10 - absDiff);

            initialLock = initialLock / 10;
            unlockCode = unlockCode / 10;
        }

        return rotations;
    }
}
