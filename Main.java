import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        System.out.println("Hello World!!!");
        Scanner read = new Scanner(System.in);
        Elemento element = new Elemento(0);

        ArvoreAVL arvore = new ArvoreAVL(new Elemento(read.nextInt()));
        arvore.calcularBalanceamento();
        System.out.println(arvore.printArvore(0));

        while(true){
            arvore = arvore.inserir(new Elemento(read.nextInt()));
            arvore.calcularBalanceamento();
            System.out.println(arvore.printArvore(0));

        }

        /*Elemento element;

        ArvoreAVL arvore = new ArvoreAVL(new Elemento(20));
        arvore.inserir(new Elemento(10));
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(2));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(18));
        arvore.inserir(new Elemento(30));
        arvore.inserir(new Elemento(25));
        arvore.inserir(new Elemento(22));
        arvore.inserir(new Elemento(28));
        arvore.inserir(new Elemento(35));
        arvore.inserir(new Elemento(32));
        arvore.inserir(new Elemento(38));


        System.out.println("O elemnto 1"+(arvore.busca(1)?" existe" : " não existe"));
        System.out.println("O elemnto 10"+(arvore.busca(10)?" existe" : " não existe"));
        System.out.println("O elemnto 12"+(arvore.busca(12)?" existe" : " não existe"));
        System.out.println("O elemnto 14"+(arvore.busca(14)?" existe" : " não existe"));
        System.out.println("O elemnto 17"+(arvore.busca(17)?" existe" : " não existe"));

        arvore.imprimirInOrdem();
        System.out.println(" ");

        element = new Elemento(38);
        arvore.remover(element);
        System.out.println("Nova arvore após a remoção do 38");
        arvore.imprimirInOrdem();
        System.out.println(" ");

        element = new Elemento(35);
        arvore.remover(element);
        System.out.println("Nova arvore após a remoção do 35");
        arvore.imprimirInOrdem();
        System.out.println(" ");

        element = new Elemento(20);
        arvore.remover(element);
        System.out.println("Nova arvore após a remoção do 20");
        arvore.imprimirInOrdem();
        System.out.println(" ");

*/
    }
}