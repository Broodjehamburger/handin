/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Vincent Duitsch.)
 * @version (11-2-2016.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages, String refNumber)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
    }

    // Add the methods here ...
    public void printAuthor(){
        System.out.println("Author:" + author);
    }
    
    public void printTitle(){
        System.out.println("Title:" + title);
    }
    
    public void getPages() {
        System.out.println("The amount of pages are" + pages);
    }
    
    public void setRefNumber(String ref){
        refNumber = ref;
    }
    
    public String getRefNumber(){
        return refNumber;
    }
    public void printDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("The amount of pages are " + pages);
        String refNumberString;
        if(refNumber != null) {
            refNumberString = refNumber;
        }
        else {
            refNumberString = " ZZZ";
        }
        System.out.println("The reference number is" + refNumberString);
    
    }
}
