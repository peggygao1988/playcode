package org.peggygao.algs.exercise;

import org.peggygao.algs.collections.Stack;

public class Answer139
{
	public static void main(String[] args)
	{
		// String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		String expression = "2 + 3 + 4 ) * 5 * 6 ) * 7 - 8 ) ) ) )";
		// 操作数栈
		Stack<String> s1 = new Stack<String>();
		// 运算符栈
		Stack<String> s2 = new Stack<String>();
		// 处理结果
		String result = "";
		int i = 0;
		// 对应操作数栈、运算符栈中的元素
		String ch, ch1;
		// 把将要处理的字符串以空格截取为字符串数组
		String[] as = expression.split(" ");
		int length = as.length;
		for (i = 0; i < length; i++)
		{
			ch = as[i];
			// 如果是操作数的情况，直接放入操作数栈
			if (isOperand(ch))
			{
				s1.push(ch);
			}
			else
			{
				// 如果是运算符的情况
				if (isOperand2(ch))
				{
					// 运算符栈中有寄存的运算符时
					if (!s2.isEmpty())
					{
						ch1 = s2.pop();
						// 如果运算符栈顶元素的优先级大于等于读取到的运算符（一般这种情况是遇到乘号或除号；或者表达式中连续出现多个相同优先级的运算符）
						if (priority(ch.toCharArray()[0]) <= priority(ch1.toCharArray()[0]))
						{
							// 取得‘（’最后一次出现的位置
							int y = result.lastIndexOf('(');
							// 这是处理算数表达式中间有乘号或除号的情况，比如“1 + 2 ) * 3 - ”
							if (y != -1)
							{
								// 用‘（’将乘号或除号之前最小计算单元括起来
								result = result.substring(0, y) + '(' + result.substring(y, result.length()) + ch1;
								// 将读取的运算符存入运算符栈
								s2.push(ch);
							}
							else
							{
								// 这是处理表达式开头部分连续出现多个相同优先级的运算符
								// 栈是后进先出，所以先将最后加进的元素弹出，存起来备用
								String itemTmp = s1.pop();
								// 相当于处理表达式的第一个元素
								result = '(' + s1.pop() + ch1;
								// 重新将最后加进的元素压入操作数栈
								s1.push(itemTmp);
								// 将读入的运算符压入运算符栈
								s2.push(ch);
							}
						}
						else
						{
							s2.push(ch1);
							s2.push(ch);
						}
					}
					else
					{
						s2.push(ch);
					}
				}
				else if (ch.equals(")"))
				{
					// 遇见“）”且操作数栈不为空时，分别从操作数栈，运算符栈中弹出所需的操作数和对应运算符，并且给处理结果添加“（”
					if (!s1.isEmpty())
					{
						String temp = s1.pop();
						result += "(" + s1.pop() + s2.pop() + temp + ch;
					}
					else
					{
						result += ")";
					}
				}
			}
		}
		System.out.println(result);
	}

	// 判断是否是操作数
	private static boolean isOperand(String ch)
	{
		String[] operators = { "+", "-", "*", "/", "(", ")" };
		for (int i = 0; i < operators.length; i++)
			if (ch.equals(operators[i]))
				return false;
		return true;
	}

	// 判断是否是运算符
	private static boolean isOperand2(String ch)
	{
		String[] operators = { "+", "-", "*", "/" };
		for (int i = 0; i < operators.length; i++)
			if (ch.equals(operators[i]))
				return true;
		return false;
	}

	// 返回运算符的优先级
	private static int priority(char ch)
	{
		int pri;
		switch (ch)
		{
		case '+':
			pri = 1;
			break;
		case '-':
			pri = 1;
			break;
		case '*':
			pri = 2;
			break;
		case '/':
			pri = 2;
			break;
		default:
			pri = 0;
			break;
		}
		return pri;
	}
}
