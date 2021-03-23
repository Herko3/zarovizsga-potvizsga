package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int sum = cleanables.stream()
                .mapToInt(Cleanable::clean)
                .sum();
        cleanables = Collections.emptyList();


//        int sum = 0;
//        Iterator<Cleanable> iterator = cleanables.iterator();
//        while(iterator.hasNext()){
//            Cleanable actual = iterator.next();
//            sum+= actual.clean();
//            iterator.remove();
//        }
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()) {
            Cleanable actual = iterator.next();
            if (actual instanceof Office) {
                sum += actual.clean();
                iterator.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream()
                .filter(c -> c.getAddress().contains(address))
                .collect(Collectors.toList());
    }

    public String getAddresses() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < cleanables.size(); i++) {
//            sb.append(cleanables.get(i).getAddress());
//            if(i != cleanables.size()-1){
//                sb.append(", ");
//            }
//        }
//        return sb.toString();

        return cleanables.stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }
}
