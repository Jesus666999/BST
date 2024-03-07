package Principal;
public class run {
    public static void main(String[] args) {
        Tree arbol = new Tree(25, "BLACK");
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.sort(arbol, (int) (Math.random() * (100 - 1) + 1));
        arbol.balance(arbol);
        
        System.out.println("Preorder");
        arbol.preorder();
        System.out.println("_________________________________\nPostorder\n");
        arbol.postorder();
        System.out.println("_________________________________\nIn order\n");
        arbol.inorder(arbol);
        System.out.println("_________________________________\n");
        System.out.println("_________________________________\n");
        
        System.out.println("_________________________________\n");
        arbol.printLevelOrder(arbol);
    }
    
}
