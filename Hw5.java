import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Hw5 {

    public static void main(String[] args) {

// 1. Создать словарь HashMap. Обобщение <Integer, String>.
        HashMap<Integer,String> Fio = new HashMap<>();

// 2. Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключ, если не было!)
        Fio.put(0, "Ильин Федор Ярославович 24 м");
        Fio.put(1, "Быкова Алла Мэлоровна 33 ж");
        Fio.put(2, "Суханов Панкратий Наумович 56 м");
        Fio.put(3, "Кудрявцева Екатерина Геласьевна 63 ж");
        Fio.put(4, "Копылов Нинель Еремеевич 45 м");
        Fio.put(5, "Герасимова Юстина Ефимовна 18 ж");
        Fio.put(6, "Артемьев Дональд Ефимович 12 м");
        Fio.put(7, "Белоусова Фанни Сергеевна 43 ж");
        Fio.put(8, "Исаков Юлий Рубенович 26 м");
        Fio.put(9, "Корнилова Лаура Богдановна 22 ж");
        // System.out.println(Fio);
        changeLetter(Fio);
        Fio.entrySet()
                .forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));;

// 4.Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
        Set<Integer> keys = Fio.keySet();
        System.out.println("\nЗначение в формате фамилия + инициалы: ");
        for (Integer key: keys) {
            String asd1 = Fio.get(key).split(" ")[0];
            String asd = asd1.toUpperCase().charAt(0)+asd1.toLowerCase().substring(1, asd1.length());
            asd1 = Fio.get(key).split(" ")[1].toUpperCase().charAt(0)+".";
            asd = asd+ " " + asd1;
            asd1 = Fio.get(key).split(" ")[2].toUpperCase().charAt(0)+".";
            asd = asd + asd1;
            System.out.println(asd);
        }
// 5. *Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.
        List<String> values = new ArrayList<>(Fio.values());
        values.sort(Comparator.comparing(x -> Integer.parseInt(x.split(" ")[3])));
        System.out.println("\nОтсортированные значения по возрасту: ");
        for (String i : values) {
            String[] a = i.split(" ");
            System.out.printf("%s %s.%s. %s %s\n", a[0], a[1].substring(0, 1), a[2].substring(0, 1), a[3], a[4]);
        }
    }
    
// 3.Изменить значения сделав пол с большой буквы.
    static void changeLetter(HashMap<Integer, String> Fio){
        System.out.println();
        System.out.println("Вывод списка с обозначением пола заглавной буквой:");

        for (Integer key: Fio.keySet()){
            String str = Fio.get(key);
            int index = str.length() - 1;
            char ch = Character.toUpperCase(str.charAt(index));
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(index, ch);
            str = sb.toString();
            Fio.put(key, str);
        }

    }
     
}