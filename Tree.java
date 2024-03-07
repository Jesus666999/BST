package Principal;

public class Tree {

    int value;
    Tree right;
    Tree left;
    String color;

    public Tree() {
    }

    public Tree(int value) {
        this.value = value;
    }

    public Tree(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRed(Tree node) {
        if (node == null){
            return false;
        } else{
            if (node.getColor().equals("RED")){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void sort(Tree node, int valor) {
        Tree newBranch = new Tree(valor, "RED");
        if (valor < node.getValue()) {
            if (node.left == null) {
                node.left = newBranch;
            } else {
                sort(node.left, valor);
            }
        } else {
            if (valor > node.getValue()) {
                if (node.right == null) {
                    node.right = newBranch;
                } else {
                    sort(node.right, valor);
                }
            }
        }
        //balance(node);
    }

    public void push(int value) {
        Tree newBranch = new Tree(value);
        if (left == null) {
            left = newBranch;
        } else if (right == null) {
            right = newBranch;
        } else if (left.getLeft() == null || left.getRight() == null) {
            left.push(value);
        } else {
            right.push(value);
        }
    }

    public void preorder() {
        if (left != null) {
            System.out.println(left.getValue());
            left.preorder();
        }
        if (right != null) {
            System.out.println(right.getValue());
            right.preorder();
        }
    }

    public void postorder() {
        if (right != null) {
            System.out.println(right.getValue());
            right.postorder();
        }
        if (left != null) {
            System.out.println(left.getValue());
            left.postorder();
        }
    }

    public void inorder(Tree node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.println(node.getValue());
        inorder(node.getRight());
    }

    public Tree rotateLeft(Tree node) {
        Tree aux = new Tree();
        aux = node.getRight();
        node.right = aux.getLeft();
        aux.left = node;
        aux.setColor(node.getColor());
        node.setColor("RED");
        return aux;
    }

    public Tree rotateRight(Tree node) {
        Tree aux = new Tree();
        aux = node.getLeft();
        node.left = aux.getRight();
        aux.right = node;
        aux.setColor(node.getColor());
        node.setColor("RED");
        return aux;
    }

    public void colorFlip(Tree node) {
        node.setColor("RED");
        node.left.setColor("BLACK");
        node.right.setColor("BLACK");
    }

    public void balance(Tree node) {
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && !isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && !isRed(node.right)) {
            colorFlip(node);
        }
    }
    
    

    public void printLevelOrder(Tree root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            System.out.print("Nivel: " + i + "\n");
            printCurrentLevel(root, i);
            System.out.println("\n");
        }

    }

    public int height(Tree root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    public void printCurrentLevel(Tree root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.getValue() + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }

    }
}
