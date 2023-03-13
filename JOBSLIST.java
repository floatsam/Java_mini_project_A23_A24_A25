public abstract class JOBSLIST{} //will be and interface, such that it can be filled by extended classes down below
public class Arrlisteg {
    public static void main(String[] args){
        ArrayList ob1 = new ArrayList();
        ArrayList ob2 = new ArrayList();
        ArrayList ob3 = new ArrayList();
        ArrayList obi = new ArrayList();
        ob1.add(1);
        ob1.add(2);
        ob1.add(3);
        ob1.add(4);
        ob1.add(5);
        ob2.add(3);
        ob2.add(4);
        ob2.add(5);
        ob2.add(6);
        ob2.add(7);
        for(int i = 0; i < ob1.size(); i++){
            if(!ob3.contains(ob1.get(i))){
                ob3.add(ob1.get(i));
            }
            if(!ob3.contains(ob2.get(i))){
                ob3.add(ob2.get(i));
            }
        }
        for(Object o:ob3){
            System.out.print(o + ", ");
        }
        System.out.println();
        obi.addAll(ob1);
        obi.retainAll(ob2); 
        System.out.println(obi);
        ArrayList obremove = new ArrayList();
        obremove.addAll(ob1);
        obremove.removeAll(obremove);
        System.out.println(obremove);
    }
}
