package Date_Structures;

public interface IList {
    void InitList(int initSize);
    void ListInsert(int i,Object obj)throws Exception;
    void ListDelete(int i)throws Exception;
    void DestroyList();
    int Listlength();
    boolean Isempty();
    <T> T getElem(int i)throws Exception;
    void ClearList();
}
