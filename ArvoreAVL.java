public class ArvoreAVL{

    private Elemento ele;
    private ArvoreAVL dir;
    private ArvoreAVL esq;
    private int balance;

    public ArvoreAVL(){
        this.ele = null;
        this.dir = null;
        this.esq = null;
        this.balance = 0;
    }

    public ArvoreAVL(Elemento element){
        this.ele = element;
        this.dir = null;
        this.esq = null;
        this.balance = 0;
        System.out.println("Primeiro Elemento é "+this.ele.getValor());
    }

    public boolean isEmpty(){
        return (this.ele == null);
    }

    public int calcularAltura(){
        if(this.esq == null && this.dir == null){ // não possui filhos
            return 1;
        }
        else if (this.esq != null && this.dir == null){
            return 1;
        }
        else if(this.esq == null && this.dir !=null){
            return 1;
        }
        else{
            return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());
        }
    }

    public void calcularBalanceamento(){ //MATEMATICA
        if(this.esq == null && this.dir == null){ /
            this.balance = 0;
        }
        else if (this.esq != null && this.dir == null){
            this.balance = 0 - this.esq.calcularAltura();
        }
        else if(this.esq == null && this.dir !=null){
            this.balance = this.dir.calcularAltura() - 0;
        }
        else{
            this.balance = this.dir.calcularAltura() - this.esq.calcularAltura();
        }
        if(this.esq != null){
            this.esq.getBalanceamento();
        }
        if(this.dir != null){
            this.dir.calcularBalanceamento();
        }
    }
    //Insere um elemento na arvore, o MENOR SEMPRE a esquerda e o MAIOR SEMPRE a direita
    public ArvoreAVL inserir(Elemento novo){
        if(isEmpty()){ //caso seja vazio o elemento se torna a raiz
            this.ele = novo;
        }
        else{
            ArvoreAVL novaArvore = new ArvoreAVL(novo);
            if(novo.getValor() < this.ele.getValor()){ // compara se o novo elemento eh menor que o anterior
                if(this.esq == null){
                    this.esq = novaArvore; //se a esquerda da arvore estiver vazia, o novo elemento sera inserido
                    System.out.println("Inseri o elemento "+novo.getValor()+" a esquerda de "+this.ele.getValor());
                }else{
                    this.esq = this.esq.inserir(novo); //caso não seja vazio, ele passa a verificação para o proximo nó
                }
            }else{
                if(novo.getValor() > this.ele.getValor()){ // compara se o novo elemento eh maior que o anterior
                    if(this.dir == null){
                        this.dir = novaArvore; //se a direita da arvore estiver vazia, o novo elemento sera inserido
                        System.out.println("Inseri o elemento "+novo.getValor()+" a direita de "+this.ele.getValor());
                    }else{
                        this.dir = this.dir.inserir(novo); //caso não seja vazio, ele passa a verificação para o proximo nó
                    }
                }
            }
        }
        return this;
    }

    public ArvoreAVL remover(Elemento element){
        if(this.ele.getValor() == element.getValor()){ // caso o valor do nó seja igual ao parametro
            if(this.esq == null && this.dir == null){ // caso a arvore ou sub-arvore não tenha folhas
                return null;
            }
            else if(this.esq != null && this.dir == null){ // compara se a arvore ou sub-arvore possui nó esquerdo apenas
                return this.esq; // caso tenha, irá retornar o nó esquedo desse elemento
            }
            else if(this.esq == null && this.dir != null){ // compara se a arvore ou sub-arvore possui nó direito apenas
                return this.dir; //caso tenha, irá retornar o nó direito desse elemento
            }
            else{ // coso a arvore tenha 2 nós folhas ele pega o maior elemento do lado esquerdo da arvore
                ArvoreAVL aux = this.esq;
                while(aux.dir != null){ //enquanto a arvore tiver nós a direita
                    aux = aux.dir; // ira pular de sub-arvore em sub-arvore até achar uma direita nula
                }
                this.ele = aux.getElemento(); // quando achar, joga este nó para a raiz do no lugar onde sera apagado o elemento ecolhido anteriormente
                aux.setElemento(element); // pega o nó do escolhido para eclusão e coloca no lugar dele, basicamente trocam de lugar
                this.esq = this.esq.remover(element); // remove o nó escolhido anteriormente
            }
        }
        else if(element.getValor() < this.ele.getValor()){ // se o parametro for menor que o elemento do nó atual
            this.esq = this.esq.remover(element);          // ele passa a verificação para o elemento do nó a esquerda   
        }
        else if(element.getValor() > this.ele.getValor()){ // se o parametro for maior que o elemento do nó atual
            this.dir = this.dir.remover(element);    // ele passa a verificação para o elemento do nó a direita  
        }
        return this; // caso não tenha, retorna a arvore
    }

    public void imprimirPreOrdem(){
        if(!isEmpty()){
            System.out.print(this.ele.getValor());
            if(this.esq != null){
                this.esq.imprimirPreOrdem();
            }
            if(this.dir != null){
                this.dir.imprimirPreOrdem();
            }

        }
    }

    public void imprimirInOrdem(){ // imprime os nós a esquerda primeiro
        if(!isEmpty()){
            if(this.esq != null){
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.ele.getValor()+"  ");
            if(this.dir != null){
                this.dir.imprimirInOrdem();
            }
        }
    }

    public boolean busca(int valor){ // verifica se o valor existe em algum nó da arvore
        if(isEmpty()){
            return false;
        }
        if(this.ele.getValor() == valor){ // se o elemento do nó atual for igual ao paramentro
            return true;
        }
        else{ 
            if(valor < this.ele.getValor()){ // caso o parametro for menor que o elemento do nó atual
                if(esq == null){ // se não tiver nós a esquerda do nó atual
                   return false;
                }else{
                    return this.esq.busca(valor); // passa a verificação para o proximo nó a esquerda
                }
            }else{
                if(valor > this.ele.getValor()){ // caso o parametro for maior que o elemento do nó atual
                if(dir == null){   // se não tiver nós a direita do nó atual
                   return false;
                }else{
                    return this.dir.busca(valor); // passa a verificação para o proximo nó a direita
                }
            }
            }
            return false;
        }
    }

    public void setElemento(Elemento ele){
        this.ele = ele;
    }

    public void setDireita(ArvoreAVL dir){
        this.dir = dir;
    }

    public void setEsquerda(ArvoreAVL esq){
        this.esq = esq;
    }

    public void setBalanceamento(int bal){
        this.balance = bal;
    }

    public Elemento getElemento(){
        return this.ele;
    }

    public ArvoreAVL getDireita(){
        return this.dir;
    }

    public ArvoreAVL getEsquerda(){
        return this.esq;
    }

    public int getBalanceamento(){
        return this.balance;
    }

    public String printArvore(int level){ //ctrlC+ctrlV, não entendi a logica, mas printa a arvore bonitcha
        String str = this.toString()+"\n";
        for (int i = 0; i < level; i++) {
            str += "\t";
        }
        if(this.esq != null){
            str += "+- ESQ: "+ this.esq.printArvore(level + 1);
        }
        else{
            str += "+- ESQ: NULL";
        }
        str += "\n";
        for (int i = 0; i < level; i++) {
            str += "\t";
        }
        if(this.dir != null){
            str += "+- DIR: "+ this.dir.printArvore(level + 1);
        }
        else{
            str += "+- DIR: NULL";
        }
        str += "\n";

        return str;
    }
    
    public String toString(){
        return "["+this.ele.getValor()+"] ("+this.balance+")";
    }


}