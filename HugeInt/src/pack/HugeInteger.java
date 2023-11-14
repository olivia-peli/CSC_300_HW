package pack;

public class HugeInteger extends MyDoublyLinkedList<Integer>{
	public char Sign;
	
	public HugeInteger() {
		super();
		this.Sign = '+';
	}
	
	public HugeInteger(String input, char sign) {
		this.Sign = sign;
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			this.Append(Character.getNumericValue(c));
		}
	}
	
	@Override
	public String toString() {
		String output = "";
		output += this.Sign;
		MyDoubleNode<Integer> node = this.Head;
		while(node != null) {
			output += node.Data;
			node = node.NextNode;
		}
		return output;
	}
	
	public HugeInteger ReverseSign() {
		String value = this.toString().substring(1);
		return new HugeInteger(value, this.Sign == '+' ? '-' : '+');
	}
	
	public int compare(HugeInteger hi) {
		if (this.Sign == hi.Sign && this.Sign == '+') {
			//1 compare length
			if (this.Size > hi.Size) {
				return 1;
			} else if (this.Sign < hi.Size){
				return -1;
			} else {
			//2 compare from head to tail one by one
				MyDoubleNode<Integer> thisNode = this.Head;
				MyDoubleNode<Integer> hiNode = hi.Head;
				while (thisNode != null) {
					if (thisNode.Data > hiNode.Data) {
						return 1;
					} else if (thisNode.Data < hiNode.Data){
						return -1;
					} else {
						thisNode = thisNode.NextNode;
						hiNode = hiNode.NextNode;
					}
				}
				return 0;
			}
		} else if (this.Sign == hi.Sign && this.Sign == '-') {
			HugeInteger thisReverse = this.ReverseSign();
			HugeInteger hiReverse = hi.ReverseSign();
			return thisReverse.compare(hiReverse);
		} else {
			if (this.Sign == '+') {
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	public HugeInteger plus(HugeInteger hi) {
		HugeInteger result = new HugeInteger();
		int carrier = 0;
		int count = this.Size > hi.Sign ? this.Size : hi.Size;
		MyDoubleNode<Integer> thisNode = this.Tail;
		MyDoubleNode<Integer> hiNode = hi.Tail;
		int a = 0;
		int b = 0;
		while (count > 0) {
			if (thisNode != null) {
				a = thisNode.Data;
				thisNode = thisNode.PreviousNode;
			} else {
				a = 0;
			}
			if (hiNode != null) {
				b = hiNode.Data;
				hiNode = hiNode.PreviousNode;
			} else {
				b = 0;
			}
			int c = a + b + carrier;
			if (c >= 10) {
				result.Prepend(c - 10);
				carrier = 1;
			} else {
				result.Prepend(c);
				carrier = 0;
			}
		}
		if (carrier == 1) {
			result.Prepend(carrier);
		}
		return result;
	}
	
	public HugeInteger multiply(HugeInteger hi) {
		HugeInteger result = new HugeInteger();
		result.Append(0);
		MyDoubleNode<Integer> thisNode = hi.Tail;
		int zeros = 0;
		while(thisNode != null) {
			HugeInteger tmpResult = this.multiplySingleDigit(thisNode.Data, zeros);
			result = result.plus(tmpResult);
			zeros++;
			thisNode = thisNode.PreviousNode;
		}
		return result;
	}
	
	public HugeInteger multiplySingleDigit(int i, int zeros) {
		int carrier = 0;
		int tmpResult = 0;
		HugeInteger result = new HugeInteger();
		MyDoubleNode<Integer> thisNode = this.Tail;
		while(thisNode != null) {
			tmpResult = carrier + thisNode.Data * i;
			result.Prepend(tmpResult % 10);
			carrier = tmpResult / 10;
			thisNode = thisNode.PreviousNode;
		}
		if (carrier > 0) {
			result.Prepend(carrier);
		}
		for(int k = 0; k < zeros; k++) {
			result.Append(0);
		}
		return result;
	}
	
}


