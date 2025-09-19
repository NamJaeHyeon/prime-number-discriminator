class Prime
{
    public static final int MAX = 100000;
    public static int primeNum = 0;
    public static int[] prime = new int[MAX];

    static {
        prime[primeNum++] = 2;
    }

    public static void main(String[] args)
    {
        /* java Prime [down] [up] */
        int down = Integer.parseInt(args[0]);
        int up = Integer.parseInt(args[1]);

        for(int i = down; i < up + 1; i++)
        {
            if (isPrime(i)) System.out.println(i + "은 소수입니다."); // 소수인 경우
            else System.out.println(i + "은 소수가 아닙니다."); // 소수가 아닌 경우
        }
    }

    public static void findNextPrime()
    {
        /* 소수 생성 */
        for(int i = prime[primeNum - 1] + 1;;i++){
            if(isPrime(i)) // i가 소수라면
            {
                prime[primeNum++] = i;
                return;
            }
        }
    }

    public static boolean isPrime(int num)
    {
        /* num이 소수인지 판별하는 메서드 */
        int k = (int)(Math.sqrt((double)num));
        if(num < 2) return false;
        
        while (prime[primeNum - 1] <= k)
        {
            /* 루트(num)보다 작거나 같은 소수들 생성 */
            findNextPrime();
        }
        
        for(int i = 0; prime[i] <= k; i++)
        {
            /* 루트(num)보다 작거나 같은 모든 소수들로 나머지 확인 */
            if(num % prime[i] == 0) return false;
        }
        return true;
    }
}
