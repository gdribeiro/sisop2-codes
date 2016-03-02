/**
 * MySharedResource class
 */
public class MySharedResource
{
	private int fieldA;
	private int fieldB;
	private int fieldC;
	private boolean empty;
	
	public MySharedResource() {	this.empty = true; }
	
	public int getFieldA() { return fieldA; }
	public int getFieldB() { return fieldB; }
	public int getFieldC() { return fieldC; }
	
	public void setFieldA(int fieldA) { this.fieldA  = fieldA; }
	public void setFieldB(int fieldB) { this.fieldB  = fieldB; }
	public void setFieldC(int fieldC) { this.fieldC  = fieldC; }
	
	public boolean isEmpty() { return empty; }
	public void setEmpty(boolean empty) { this.empty = empty; }
}