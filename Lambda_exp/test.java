package Lambda_exp;

public class test {
    public static void main(String[] args) {
        Student eng_std = new Student() {
            @Override
            public String getBio(String name){
                return name + " is an engineering student.";
            }
        };

        Student law_std = (name) -> name + " is a law student.";
        
        Student med_std = (String name) -> {
            String year = "final year";
            return name + " is a med student. Also " + year + " student.";
        };
        String bio = eng_std.getBio("RAHUL");
        System.out.println(bio);

        String bio2 = law_std.getBio("VIRAT");
        System.out.println(bio2);

        String bio3 = med_std.getBio("DHONI");
        System.out.println(bio3);
    }
}
