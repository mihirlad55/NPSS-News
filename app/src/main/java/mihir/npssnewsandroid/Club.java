package mihir.npssnewsandroid;


import android.util.Log;

public class Club {

    public Club(String name, String description, Gender gender, Grade grade) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.grade = grade;
    }

    private static final String TAG = "ClubClass";

    public enum Gender {
        MALE(0), FEMALE(1);

        private int _value;

        Gender(int value) { this._value = value; }

        public int getValue() { return _value; }

        public static Gender fromInt(int i) {
            for (Gender g : Gender.values()) {
                if (g.getValue() == i) return g;
            }
            return null;
        }
    }

    public enum Grade {
        NINE(9), TEN(10), ELEVEN(11), TWELVE(12);

        private int _value;

        Grade(int value) { this._value = value; }

        public int getValue() { return _value; }

        public static Grade fromInt(int i) {
            for (Grade g : Grade.values()) {
                if (g.getValue() == i) return g;
            }
            return null;
        }

    }

    private String name;
    private String description;
    private Gender gender;
    private Grade grade;

    public boolean setName(String name) { this.name = name; return true; }
    public String getName() { return this.name; }

    public boolean setDescription(String description) { this.description = description; return true; }
    public String getDescription() { return this.description; }

    public boolean setGender(Gender gender) { this.gender = gender; return true; }
    public Gender getGender() { return this.gender; }

    public boolean setGrade(Grade grade) { this.grade = grade; return true; }
    public Grade getGrade() { return this.grade; }


    @Override
    public String toString() {
        String s = "";
        s += "Name: " + name + ", Description: " + description + ", Gender: ";
        s += (gender.getValue() == Gender.MALE.getValue()) ? "Male" : "Female";
        s += ", Grade: " + grade.getValue();
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Club) {
            try {
                Club c2 = (Club) o;
                return (c2.name.equals(this.name) && c2.description.equals(this.description) && c2.gender.getValue() == this.gender.getValue() && c2.grade.getValue() == this.grade.getValue());
            } catch (ClassCastException e) {
                Log.i(TAG, e.getMessage());
            }
        }
        return false;
    }
}
