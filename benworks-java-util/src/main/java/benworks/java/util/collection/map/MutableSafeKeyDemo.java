package benworks.java.util.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MutableSafeKeyDemo {
	 
    public static void main(String[] args) {
        Employee emp = new Employee(2);
        emp.setName("Robin");
 
        // Put object in HashMap.
        Map<Employee, String> map = new HashMap<>();
        map.put(emp, "Showbasky");
 
        System.out.println(map.get(emp));
 
        // Change Employee name. Change in 'name' has no effect
        // on hash code.
        emp.setName("Lily");
        System.out.println(map.get(emp));
    }
}
 
class Employee {
    // It is specified while object creation.
    // Cannot be changed once object is created. No setter for this field.
    private int id;
    private String name;
 
    public Employee(final int id) {
        this.id = id;
    }
 
    public final String getName() {
        return name;
    }
 
    public final void setName(final String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    // Hash code depends only on 'id' which cannot be
    // changed once object is created. So hash code will not change
    // on object's state change
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }
}