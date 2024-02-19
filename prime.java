class prime
{
    public static int primeNum = 0;
    public static int[] prime = new int[100000];

    public static void main(String[] args)
    {

        int down = Integer.parseInt(args[0]);
        int up = Integer.parseInt(args[1]);
        prime[primeNum++] = 2;

        for(int i = down; i < up + 1; i++){
            if(isPrime(i))
            {
                System.out.println(i + "은 소수입니다.");
            } else {
                System.out.println(i + "은 소수가 아닙니다.");
            }
        }
        
    }

    public static void completePrime()
    {
        for(int i = prime[primeNum - 1] + 1;;i++){
            if(isPrime(i))
            {
                prime[primeNum++] = i;
                return;
            }
        }
    }

    public static boolean isPrime(int num)
    {
        int k = (int)(Math.sqrt((double)num));
        while (prime[primeNum - 1] <= k)
        {
            completePrime();
        }
        for(int i = 0; prime[i] <= k; i++)
        {
            if(num % prime[i] == 0) return false;
        }
        return true;
    }
}
