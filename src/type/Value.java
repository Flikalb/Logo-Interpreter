package type;

import java.io.Serializable;
import java.util.ArrayList;

import syntaxtree.AbsValueNode;
import syntaxtree.ListDataVNode;

public class Value implements Serializable, Cloneable {

    private static final long serialVersionUID = -5561717466435045800L;

    private VariableType type = null;
    private Object value = null;

    public Value() {
    }

    public Value(String v) {
        this.value = v;
        this.type = VariableType.STRING;
    }

    public Value(Boolean v) {
        this.value = v;
        this.type = VariableType.BOOLEAN;
    }

    public Value(Number v) {
        this.value = v;
        this.type = VariableType.NUMBER;
    }

    public Value(ArrayList<Value> v) {
        this.value = v;
        this.type = VariableType.ARRAYLIST;
    }

    public VariableType getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public <T> T getValue(Class<T> type) {
        return type.cast(value);
    }

    public void set(Value v) {
        if (v == null) {
            this.value = null;
            this.type = null;
        } else {
            this.value = v.value;
            this.type = v.type;
        }
    }

    public void set(String v) {
        this.value = v;
        this.type = VariableType.STRING;
    }

    public void set(Boolean v) {
        this.value = v;
        this.type = VariableType.BOOLEAN;
    }

    public void set(Number v) {
        this.value = v;
        this.type = VariableType.NUMBER;
    }

    @Override
    public String toString() {
        if (type == VariableType.ARRAYLIST) {
            StringBuilder str = new StringBuilder();
            str.append("[");
            for (Value val : (ArrayList<Value>) value) {

                str.append(val.toString());

                if (!val.equals(((ArrayList<Value>) value).get(((ArrayList<Value>) value).size() - 1))) {
                    str.append(" ");
                }
            }
            str.append("]");
            return str.toString();
        } else if (type == VariableType.BOOLEAN) {
            if ((Boolean) this.value)
                return "true";
            else
                return "false";
        } else
            return this.value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this.value)
            return true;
        if (obj instanceof Value) {
            Value v = (Value) obj;
            return this.type == v.type && (this.value == v.value || (this.value != null && this.value.equals(v.value)));
        } else {
            return (this.value.equals(obj));
        }
    }

}
