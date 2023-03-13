//.... list the amount of job types available, will have to make a lot of presets for the sake of robustness
class rmv{
    public static void main(String[] args){
        ArrayList ob1 = new ArrayList();
        ob1.add(4);
        ob1.add(7);
        ob1.add(9);
        ob1.add(9);
        ob1.add(8);
        ob1.add(7);
        ob1.add(6);
        ob1.add(5);
        ob1.add(5);
        ob1.add(5);
        for(int i = 0; i < ob1.size(); i++){
            while(ob1.indexOf(ob1.get(i)) != ob1.lastIndexOf(ob1.get(i)))
                ob1.remove(ob1.lastIndexOf(ob1.get(i)));
        }
        for(Object o:ob1){
            System.out.print(o + " ");
        }
    }
}
