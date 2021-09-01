package No_19组合模式;

import java.util.ArrayList;
import java.util.List;

public class 组合模式 {
    public static void main(String[] args) {
        Province province = new Province();
        province.add(new City(1000));
        province.add(new City(2000));
        province.add(new City(2500));
        System.out.println(province.count());
    }
}

interface Count {
    int count();
}

class City implements Count {
    private int count;

    public City(int num) {
        this.count = num;
    }

    @Override
    public int count() {
        return count;
    }
}

class Province implements Count {
    private List<City> cities = new ArrayList<>();
    private int count;

    public void add(City city) {
        cities.add(city);
    }

    @Override
    public int count() {
        cities.forEach(city -> {
            count += city.count();
        });
        return count;
    }
}
