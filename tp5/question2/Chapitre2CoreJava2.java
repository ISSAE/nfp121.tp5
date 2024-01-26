package question2;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Chapitre2CoreJava2 {

    /**
     * Obtention d'une liste de mots a  partir de la constante CHAPITRE2.
     * 
     **/
    public static List<String> listeDesMots() {
        List<String> liste  = new ArrayList<>();    

        StringTokenizer st = new StringTokenizer(Chapitre2CoreJava2.CHAPITRE2,"[](){};, :.\n\"");

        while (st.hasMoreTokens()) {
            liste.add(st.nextToken());
        }

        return liste;
    }

    /**
     * Obtention d'une liste de couples <String,Integer>. 
     * A chaque mot présent dans la liste, est associé son nombre d'occurrence.
     * 
     * @param liste la liste des mots
     */
    public static Map<String, Integer> occurrencesDesMots(List<String> liste) {
        Map<String, Integer> table = new HashMap<>(); 
        
        for (String mot : liste) {
            table.put(mot, table.getOrDefault(mot, 0) + 1);
        }
        
        return table;
    }

    public static final String CHAPITRE2 =

        "Core Java 2, Volume II"
        + "\n"
        + "\n"
        +

        "by Cay S. Horstmann and Gary Cornell"
        + "\n"
        +

        "Chapter 2: Collections"
        + "\n"
        + "\n"
        +

        "Concrete Collections"
        + "\n"
        +

        "Rather than getting into more details about all the interfaces, we thought it would be helpful to first discuss the"
        + "\n"
        + "concrete data structures that the Java library supplies. Once you have a thorough understanding of what classes you"
        + "\n"
        + "will want to use, we will return to abstract considerations and see how the collections framework organizes these"
        + "\n"
        + "classes. "
        + "\n"
        +

        "Linked Lists "
        + "\n"
        +

        "We used arrays and their dynamic cousin, the Vector class, for many examples in Volume 1. However, arrays and"
        + "\n"
        + "vectors suffer from a major drawback. Removing an element from the middle of an array is very expensive since all"
        + "\n"
        + "array elements beyond the removed one must be moved toward the beginning of the array (see Figure 2-4). The"
        + "\n"
        + "same is true for inserting elements in the middle. "
        + "\n"
        +

        "                                                          "
        + "\n"
        + "Figure 2-4: Removing an element from an array "
        + "\n"
        +

        "Another well-known data structure, the linked list, solves this problem. Whereas an array stores object references in"
        + "\n"
        + "consecutive memory locations, a linked list stores each object in a separate link. Each link also stores a reference to"
        + "\n"
        + "the next link in the sequence. In the Java programming language, all linked lists are actually doubly linked, that is, each"
        + "\n"
        + "link also stores a reference to its predecessor (see Figure 2-5). "
        + "\n"
        +

        "                                                          "
        + "\n"
        + "Figure 2-5: A doubly linked list "
        + "\n"
        +

        "Removing an element from the middle of a linked list is an inexpensive operation--only the links around the element"
        + "\n"
        + "to be removed need to be updated (see Figure 2-6). "
        + "\n"
        +

        "                                                          "
        + "\n"
        + "Figure 2-6: Removing an element from a linked list "
        + "\n"
        +

        "Perhaps you once had a course in data structures where you learned how to implement linked lists. You may have"
        + "\n"
        + "bad memories of tangling up the links when removing or adding elements in the linked list. If so, you will be pleased to"
        + "\n"
        + "learn that the Java collections library supplies a class LinkedList ready for you to use. "
        + "\n"
        +

        "The LinkedList class implements the Collection interface. You can use the familiar methods to traverse a list. The"
        + "\n"
        + "following code example prints the first three elements of a list, adds three elements, and then removes the third one. "
        + "\n"
        +

        "LinkedList staff = "
        + "\n"
        + "     new LinkedList();"
        + "\n"
        + "staff.add(\"Angela\");"
        + "\n"
        + "staff.add(\"Bob\");"
        + "\n"
        + "staff.add(\"Carl\");"
        + "\n"
        + "Iterator iter = staff.iterator();"
        + "\n"
        + "for (int i = 0; i < 3; i++)"
        + "\n"
        + "   System.out.println(iter.next());"
        + "\n"
        + "iter.remove(); // remove last "
        + "\n"
        + "//visited element"
        + "\n"
        +

        "However, there is an important difference between linked lists and generic collections. A linked list is an ordered"
        + "\n"
        + "collection where the position of the objects matters. The LinkedList.add method adds the object to the end of the"
        + "\n"
        + "list. But you often want to add objects somewhere in the middle of a list. This position-dependent add method is the"
        + "\n"
        + "responsibility of an iterator, since iterators describe positions in collections. Using iterators to add elements only"
        + "\n"
        + "makes sense for collections that have a natural ordering. For example, the set data type that we discuss in the next"
        + "\n"
        + "section does not impose any ordering on its elements. Therefore, there is no add method in the Iterator interface."
        + "\n"
        + "Instead, the collections library supplies a subinterface ListIterator that contains an add method: "
        + "\n"
        +

        "interface ListIterator "
        + "\n"
        + "        extends Iterator"
        + "\n"
        + "{  void add(Object);"
        + "\n"
        + "   . . ."
        + "\n"
        + "}"
        + "\n"
        +

        "Unlike Collection.add, this method does not return a boolean--it is assumed that the add operation always succeeds. "
        + "\n"
        +

        "In addition, the ListIterator interface has two methods: "
        + "\n"
        +

        "Object previous()"
        + "\n"
        + "boolean hasPrevious()"
        + "\n"
        +

        "--that you can use for traversing a list backwards. Like the next method, the previous method returns the object that"
        + "\n"
        + "it skipped over. "
        + "\n"
        +

        "The listIterator method of the LinkedList class returns an iterator object that implements the ListIterator"
        + "\n"
        + "interface. "
        + "\n"
        +

        "ListIterator iter = "
        + "\n"
        + "         staff.listIterator();"
        + "\n"
        +

        "The add method adds the new element before the iterator position. For example, the code "
        + "\n"
        +

        "ListIterator iter = "
        + "\n"
        + "       staff.listIterator();"
        + "\n"
        + "iter.next();"
        + "\n"
        + "iter.add(\"Juliet\");"
        + "\n"
        +

        "skips past the first element in the linked list and adds \"Juliet\" before the second element (see Figure 2-7). "
        + "\n"
        +

        "                                                          "
        + "\n"
        + "Figure 2-7: Adding an element to a linked list "
        + "\n"
        +

        "If you call the add method multiple times, the elements are simply added in the order in which you supplied them."
        + "\n"
        + "They all get added in turn before the current iterator position. "
        + "\n"
        +

        "When you use the add operation with an iterator that was freshly returned from the listIterator method and that"
        + "\n"
        + "points to the beginning of the linked list, the newly added element becomes the new head of the list. When the"
        + "\n"
        + "iterator has passed the last element of the list (that is, when hasNext returns false), the added element becomes the"
        + "\n"
        + "new tail of the list. If the linked list has n elements, there are n + 1 spots for adding a new element. These spots"
        + "\n"
        + "correspond to the n + 1 possible positions of the iterator. For example, if a linked list contains three elements A, B,"
        + "\n"
        + "and C, then the four possible positions (marked as |) for inserting a new element are: "
        + "\n"
        +

        "|ABC"
        + "\n"
        + "A|BC"
        + "\n"
        + "AB|C"
        + "\n"
        + "ABC|"
        + "\n"
        +

        "NOTE: You have to be careful with the \"cursor\" analogy. The remove operation does not quite work like the"
        + "\n"
        + "BACKSPACE key. Immediately after a call to next, the remove method indeed removes the element to the left of the"
        + "\n"
        + "iterator, just like the backspace key would. However, if you just called previous, the element to the right is removed."
        + "\n"
        + "And you can't call remove twice in a row. "
        + "\n"
        +

        "Unlike the add method, which only depends on the iterator position, the remove method depends on the iterator state."
        + "\n"
        +

        "Finally, there is a set method that replaces the last element returned by a call to next or previous with a new"
        + "\n"
        + "element. For example, the following code replaces the first element of a list with a new value: "
        + "\n"
        +

        "ListIterator iter = list.listIterator();"
        + "\n"
        + "Object oldValue = iter.next(); // returns first element"
        + "\n"
        + "iter.set(newValue); // sets first element to newValue"
        + "\n"
        +

        "As you might imagine, if an iterator traverses a collection while another iterator is modifying it, confusing situations"
        + "\n"
        + "can occur. For example, suppose an iterator points before an element that another iterator has just removed. The"
        + "\n"
        + "iterator is now invalid and should no longer be used. The linked list iterators have been designed to detect such"
        + "\n"
        + "modifications. If an iterator finds that its collection has been modified by another iterator or by a method of the"
        + "\n"
        + "collection itself, then it throws a ConcurrentModificationException. For example, consider the following code: "
        + "\n"
        +

        "LinkedList list = . . .;"
        + "\n"
        + "ListIterator iter1 = "
        + "\n"
        + "        list.listIterator();"
        + "\n"
        + "ListIterator iter2 = "
        + "\n"
        + "        list.listIterator();"
        + "\n"
        + "iter1.next();"
        + "\n"
        + "iter1.remove();"
        + "\n"
        + "iter2.next(); "
        + "\n"
        + "// throws ConcurrentModificationException"
        + "\n"
        +

        "The call to iter2.next throws a ConcurrentModificationException since iter2 detects that the list was modified"
        + "\n"
        + "externally. "
        + "\n"
        +

        "To avoid concurrent modification exceptions, follow this simple rule: You can attach as many iterators to a container"
        + "\n"
        + "as you like, provided that all of them are only readers. Alternatively, you can attach a single iterator that can both"
        + "\n"
        + "read and write. "
        + "\n"
        +

        "Concurrent modification detection is achieved in a simple way. The container keeps track of the number of mutating"
        + "\n"
        + "operations (such as adding and removing elements). Each iterator keeps a separate count of the number of mutating"
        + "\n"
        + "operations that it was responsible for. At the beginning of each iterator method, the iterator simply checks whether"
        + "\n"
        + "its own mutation count equals that of the container. If not, it throws a ConcurrentModificationException. "
        + "\n"
        +

        "This is an excellent check and a great improvement over the fundamentally unsafe iterators in the C++ STL"
        + "\n"
        + "framework. Note, however, that it does not automatically make collections safe for multithreading. We discuss thread"
        + "\n"
        + "safety issues later in this chapter. "
        + "\n"
        +

        "NOTE: There is, however, a curious exception to the detection of concurrent modifications. The linked list only keeps"
        + "\n"
        + "track of structural modifications to the list, such as adding and removing links. The set method does not count as a"
        + "\n"
        + "structural modification. You can attach multiple iterators to a linked list, all of which call set to change the contents of"
        + "\n"
        + "existing links. This capability is required for a number of algorithms in the Collections class that we discuss later in this"
        + "\n"
        + "chapter. "
        + "\n"
        +

        "Now you have seen the fundamental methods of the LinkedList class. You use a ListIterator to traverse the"
        + "\n"
        + "elements of the linked list in either direction and to add and remove elements. "
        + "\n"
        +

        "As you saw in the preceding section, there are many other useful methods for operating on linked lists that are"
        + "\n"
        + "declared in the Collection interface. These are, for the most part, implemented in the AbstractCollection superclass of"
        + "\n"
        + "the LinkedList class. For example, the toString method invokes toString on all elements and produces one long string"
        + "\n"
        + "of the format [A, B, C]. This is handy for debugging. Use the contains method to check whether an element is present"
        + "\n"
        + "in a linked list. For example, the call staff.contains(\"Harry\") returns true if the linked list already contains a string that"
        + "\n"
        + "is equal to theString \"Harry\". However, there is no method that returns an iterator to that position. If you want to do"
        + "\n"
        + "something with the element beyond knowing that it exists, you have to program an iteration loop by hand. "
        + "\n"
        +

        "CAUTION: The Java platform documentation points out that you should not add a reference of a collection to itself."
        + "\n"
        + "Otherwise, it is easy to generate a stack overflow in the JavaTM virtual machine1. For example, the following call is"
        + "\n"
        + "fatal: "
        + "\n"
        +

        " "
        + "\n"
        + "LinkedList list = new LinkedList();"
        + "\n"
        + "list.add(list); "
        + "\n"
        + "// add list to itself"
        + "\n"
        + "String contents = list.toString(); "
        + "\n"
        + "// dies with infinite recursion"
        + "\n"
        +

        "Naturally, this is not a situation that comes up in everyday programming."
        + "\n"
        +

        "The library also supplies a number of methods that are, from a theoretical perspective, somewhat dubious. Linked"
        + "\n"
        + "lists do not support fast random access. If you want to see the nth element of a linked list, you have to start at the"
        + "\n"
        + "beginning and skip past the first n - 1 elements first. There is no shortcut. For that reason, programmers don't usually"
        + "\n"
        + "use linked lists in programming situations where elements need to be accessed by an integer index. "
        + "\n"
        +

        "Nevertheless, the LinkedList class supplies a get method that lets you access a particular element: "
        + "\n"
        +

        "Object obj = list.get(n);"
        + "\n"
        +

        "Of course, this method is not very efficient. If you find yourself using it, you are probably using the wrong data"
        + "\n"
        + "structure for your problem. "
        + "\n"
        +

        "You should never use this illusory random access method to step through a linked list. The code "
        + "\n"
        +

        "for (int i = 0; i < list.size(); i++)"
        + "\n"
        + "   do something with list.get(i);"
        + "\n"
        + "   "
        + "\n"
        +

        "is staggeringly inefficient. Each time you look up another element, the search starts again from the beginning of the"
        + "\n"
        + "list. The LinkedList object makes no effort to cache the position information. "
        + "\n"
        +

        "NOTE: The get method has one slight optimization: if the index is at least size() / 2, then the search for the element"
        + "\n"
        + "starts at the end of the list. "
        + "\n"
        +

        "The list iterator interface also has a method to tell you the index of the current position. In fact, because Java"
        + "\n"
        + "iterators conceptually point between elements, it has two of them: the nextIndex method returns the integer index of"
        + "\n"
        + "the element that would be returned by the next call to next; the previousIndex method returns the index of the"
        + "\n"
        + "element that would be returned by the next call to previous. Of course, that is simply one less than nextIndex. These"
        + "\n"
        + "methods are efficient--the iterators keep a count of the current position. Finally, if you have an integer index n, then"
        + "\n"
        + "list.listIterator(n) returns an iterator that points just before the element with index n. That is, calling next yields"
        + "\n"
        + "the same element as list.get(n). Of course, obtaining that iterator is inefficient. "
        + "\n"
        +

        "If you have a linked list with only a handful of elements, then you don't have to be overly paranoid about the cost of"
        + "\n"
        + "the get and set methods. But then why use a linked list in the first place? The only reason to use a linked list is to"
        + "\n"
        + "minimize the cost of insertion and removal in the middle of the list. If you only have a few elements, you can just use"
        + "\n"
        + "an array or a collection such as ArrayList. "
        + "\n"
        +

        "We recommend that you simply stay away from all methods that use an integer index to denote a position in a linked"
        + "\n"
        + "list. If you want random access into a collection, use an array or ArrayList, not a linked list. "
        + "\n"
        +

        "The program in Example 2-1 puts linked lists to work. It simply creates two lists, merges them, then removes every"
        + "\n"
        + "second element from the second list, and finally tests the removeAll method. We recommend that you trace the"
        + "\n"
        + "program flow and pay special attention to the iterators. You may find it helpful to draw diagrams of the iterator"
        + "\n"
        + "positions, like this: "
        + "\n"
        +

        "|ACE   |BDFG"
        + "\n"
        + "A|CE   |BDFG"
        + "\n"
        + "AB|CE  B|DFG"
        + "\n"
        + ". . ."
        + "\n"
        +

        "Note that the call "
        + "\n"
        +

        "System.out.println(a);"
        + "\n"
        +

        "prints all elements in the linked list a. "
        + "\n"
        +

        "Example 2-1: LinkedListTest.java "
        + "\n"
        +

        "import java.util.*;"
        + "\n"
        +

        "public class LinkedListTest"
        + "\n"
        + "{  public static void main("
        + "\n"
        + "                  String[] args)"
        + "\n"
        + "   {  List a = new LinkedList();"
        + "\n"
        + "      a.add(\"Angela\");"
        + "\n"
        + "      a.add(\"Carl\");"
        + "\n"
        + "      a.add(\"Erica\");"
        + "\n"
        + "      "
        + "\n"
        + "      List b = new LinkedList();"
        + "\n"
        + "      b.add(\"Bob\");"
        + "\n"
        + "      b.add(\"Doug\");"
        + "\n"
        + "      b.add(\"Frances\");"
        + "\n"
        + "      b.add(\"Gloria\");"
        + "\n"
        + "      "
        + "\n"
        + "      // merge the words from b into a"
        + "\n"
        + "      "
        + "\n"
        + "      ListIterator aIter = a.listIterator();"
        + "\n"
        + "      Iterator bIter = b.iterator();"
        + "\n"
        + "      "
        + "\n"
        + "      while (bIter.hasNext())"
        + "\n"
        + "      {  if (aIter.hasNext()) aIter.next();"
        + "\n"
        + "         aIter.add(bIter.next());"
        + "\n"
        + "      }"
        + "\n"
        + "      "
        + "\n"
        + "      System.out.println(a);"
        + "\n"
        + "      "
        + "\n"
        + "      // remove every second "
        + "\n"
        + "      //word from b"
        + "\n"
        + "      "
        + "\n"
        + "      bIter = b.iterator();"
        + "\n"
        + "      while (bIter.hasNext())"
        + "\n"
        + "      {  bIter.next(); "
        + "\n"
        + "      // skip one element"
        + "\n"
        + "         if (bIter.hasNext()) "
        + "\n"
        + "         {  bIter.next(); "
        + "\n"
        + "         // skip next element"
        + "\n"
        + "            bIter.remove(); "
        + "\n"
        + "            // remove that element"
        + "\n"
        + "         }"
        + "\n"
        + "      }"
        + "\n"
        + "      "
        + "\n"
        + "      System.out.println(b);"
        + "\n"
        + "      "
        + "\n"
        + "      // bulk operation: remove all "
        + "\n"
        + "      //words in b from a"
        + "\n"
        + "      "
        + "\n"
        + "      a.removeAll(b);"
        + "\n"
        + "      "
        + "\n"
        + "      System.out.println(a);"
        + "\n"
        + "      "
        + "\n"
        + "   }"
        + "\n"
        + "}"
        + "\n"
        + " "
        + "\n"
        +

        "java.util.List "
        + "\n"
        +

        "     ListIterator listIterator()"
        + "\n"
        + "     returns a list iterator for visiting the elements of the list. "
        + "\n"
        + "     ListIterator listIterator(int index)"
        + "\n"
        + "     returns a list iterator for visiting the elements of the list whose first call to next will return the element with the"
        + "\n"
        + "     given index. Parameters: index the position of the next visited element "
        + "\n"
        + "     void add(int i, Object element)"
        + "\n"
        + "     adds an element at the specified position. "
        + "\n"
        + "     Parameters: index the position of the new element element the element to add "
        + "\n"
        + "     void addAll(int i, Collection elements)"
        + "\n"
        + "     adds all elements from a collection to the specified position."
        + "\n"
        + "     Parameters: index the position of the first new element"
        + "\n"
        + "     elements the elements to add "
        + "\n"
        + "     Object remove(int i)"
        + "\n"
        + "     removes and returns an element at the specified position."
        + "\n"
        + "     Parameters: index the position of the element to remove "
        + "\n"
        + "     Object set(int i, Object element)"
        + "\n"
        + "     replaces the element at the specified position with a new element and returns the old element. "
        + "\n"
        + "     Parameters: index the replacement position"
        + "\n"
        + "     element the new element "
        + "\n"
        + "     int indexOf(Object element)"
        + "\n"
        + "     returns the position of the first occurrence of an element equal to the specified element, or -1 if no matching"
        + "\n"
        + "     element is found. Parameters: element the element to match "
        + "\n"
        +

        "java.util.ListIterator "
        + "\n"
        +

        "     void add(Object element)"
        + "\n"
        + "     adds an element before the current position. Parameters: element the element to add "
        + "\n"
        + "     void set(Object element)"
        + "\n"
        + "     replaces the last element visited by next or previous with a new element. Throws an IllegalStateException if"
        + "\n"
        + "     the list structure was modified since the last call to next or previous."
        + "\n"
        + "     Parameters: element the new element "
        + "\n"
        + "     boolean hasPrevious()"
        + "\n"
        + "     returns true if there is another element to visit when iterating backwards through the list. "
        + "\n"
        + "     Object previous()"
        + "\n"
        + "     returns the previous object. Throws a NoSuchElementException if the beginning of the list has been reached. "
        + "\n"
        + "     int nextIndex()"
        + "\n"
        + "     returns the index of the element that would be returned by the next call to next. "
        + "\n"
        + "     int previousIndex()"
        + "\n"
        + "     returns the index of the element that would be returned by the next call to previous. "
        + "\n"
        +

        "java.util.LinkedList "
        + "\n"
        +

        "     LinkedList()"
        + "\n"
        + "     constructs an empty linked list. "
        + "\n"
        + "     LinkedList(Collection elements)"
        + "\n"
        + "     constructs a linked list and adds all elements from a collection. "
        + "\n"
        + "     Parameters: elements the elements to add "
        + "\n"
        + "     void addFirst(Object element)"
        + "\n"
        + "     void addLast(Object element)"
        + "\n"
        + "     add an element to the beginning or the end of the list. "
        + "\n"
        + "     Parameters: element the element to add "
        + "\n"
        + "     Object getFirst() "
        + "\n"
        + "     Object getLast()"
        + "\n"
        + "     return the element at the beginning or the end of the list. "
        + "\n" + "     Object removeFirst() " + "\n"
        + "     Object removeLast() " + "\n" +

        "remove and return the element at the beginning or the end of the list. ";

}
