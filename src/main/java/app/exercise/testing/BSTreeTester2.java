package app.exercise.testing;// This class was created by PaintableToast

import app.exercise.adt2.BSTree;
import app.exercise.adt2.Node;
import app.exercise.algebra.CompRational;

public class BSTreeTester2 {
    public final static void main(final String[] args) {
        CompRational[] comp_rational_list;
        if(args.length % 2 == 0) {
            comp_rational_list = new CompRational[args.length];
            for (int i = 0; i < args.length; i += 2)
                comp_rational_list[i / 2] = new CompRational(Long.parseLong(args[i]), Long.valueOf(args[i + 1]));
            final BSTree<CompRational> tree = new BSTree<>(new Node<>(comp_rational_list[0]));
            for (final CompRational comprational : comp_rational_list)
                tree.add(comprational);
            final Object[] comp_rational_array =  tree.toArray();
            final BSTree<CompRational> second_tree1 = new BSTree<>(new Node<>((CompRational) comp_rational_array[0]));
            final BSTree<CompRational> second_tree2 = new BSTree<>(new Node<>((CompRational) comp_rational_array[1]));
            for (int i = 0; i < comp_rational_array.length; i += 2) {
                second_tree1.add((CompRational) comp_rational_array[i]);
                second_tree2.add((CompRational) comp_rational_array[i + 1]);
            }
            System.out.println("PRIMÄRER SUCHBAUM");
            for (Object comprational : tree.toArray())
                System.out.println(comprational);
            System.out.println("\nSEKUNDÄRER SUCHBAUM_1");
            for (Object comprational : second_tree1.toArray())
                System.out.println(((CompRational) comprational).toString());
            System.out.println("\nSEKUNDÄRER SUCHBAUM_2");
            for (Object comprational : second_tree2.toArray())
                System.out.println(((CompRational) comprational).toString());
        } else System.out.println("Gib mehr Zahlen argumente ein (gerade)!");


    }
}