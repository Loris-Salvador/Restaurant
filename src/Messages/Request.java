package Messages;

import java.io.Serializable;

public class Request implements Serializable {
    private TypeRequete type;

    public Request(){}
    public Request(TypeRequete Type)
    {
        type = Type;
    }
    public TypeRequete getType() {
        return type;
    }

    public void setType(TypeRequete type) {
        this.type = type;
    }
}
