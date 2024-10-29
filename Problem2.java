import java.util.*;

import static java.lang.System.in;

public class Main {

    private static void logic(Integer totalFamily, List<Integer> listFamilyMember) {

        Integer maxPersonPerBus = 4;
        Integer countBus = 0;
        listFamilyMember.sort(Collections.reverseOrder());

        if (totalFamily == listFamilyMember.size()) {

            Iterator<Integer> iterator = listFamilyMember.iterator();
            while (iterator.hasNext()) {
                Integer familyMemberCount = iterator.next();
                if (familyMemberCount.equals(maxPersonPerBus)) {
                    iterator.remove();
                    countBus = countBus + 1;
                }
            }

            int index = 0;
            while (index < listFamilyMember.size()) {
                Integer familyMemberCount = listFamilyMember.get(index);

                if (familyMemberCount == 3 && listFamilyMember.contains(1)) {
                    listFamilyMember.remove(index);
                    listFamilyMember.remove(listFamilyMember.indexOf(1));
                    countBus = countBus + 1;
                } else if (familyMemberCount == 2 && listFamilyMember.lastIndexOf(2) > index) {
                    listFamilyMember.remove(index);
                    listFamilyMember.remove(listFamilyMember.lastIndexOf(2));
                    countBus = countBus + 1;
                } else {
                    index = index + 1;
                }

            }

            System.out.print("Minimum bus required is : ");
            System.out.println(countBus);
        } else {
            System.out.println("Input must be equal with count of family");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);

        System.out.print("Input the number of families : ");
        Integer totalFamily = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Input the number of members in the family (separated by a space) : ");
        String stringInput = scanner.nextLine();
        String[] listStringInput = stringInput.split(" ");

        List<Integer> listFamilyMember = new ArrayList<>();

        for (String number : listStringInput) {
            listFamilyMember.add(Integer.parseInt(number));
        }

        logic(totalFamily, listFamilyMember);
    }
}