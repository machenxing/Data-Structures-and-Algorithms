package Date_Structures.List;

public interface IList {
    void InitList(int initSize);
    void ListInsert(int i,Object obj)throws Exception;
    void ListDelete(int i)throws Exception;
    void DestroyList();
    int ListLength();
    boolean IsEmpty();
    <T> T getElem(int i)throws Exception;
    void ClearList();
}
