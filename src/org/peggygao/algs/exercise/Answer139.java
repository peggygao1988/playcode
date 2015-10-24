package org.peggygao.algs.exercise;

import org.peggygao.algs.collections.Stack;

public class Answer139
{
	public static void main(String[] args)
	{
		// String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		String expression = "2 + 3 + 4 ) * 5 * 6 ) * 7 - 8 ) ) ) )";
		// ������ջ
		Stack<String> s1 = new Stack<String>();
		// �����ջ
		Stack<String> s2 = new Stack<String>();
		// ������
		String result = "";
		int i = 0;
		// ��Ӧ������ջ�������ջ�е�Ԫ��
		String ch, ch1;
		// �ѽ�Ҫ������ַ����Կո��ȡΪ�ַ�������
		String[] as = expression.split(" ");
		int length = as.length;
		for (i = 0; i < length; i++)
		{
			ch = as[i];
			// ����ǲ������������ֱ�ӷ��������ջ
			if (isOperand(ch))
			{
				s1.push(ch);
			}
			else
			{
				// ���������������
				if (isOperand2(ch))
				{
					// �����ջ���мĴ�������ʱ
					if (!s2.isEmpty())
					{
						ch1 = s2.pop();
						// ��������ջ��Ԫ�ص����ȼ����ڵ��ڶ�ȡ�����������һ����������������˺Ż���ţ����߱��ʽ���������ֶ����ͬ���ȼ����������
						if (priority(ch.toCharArray()[0]) <= priority(ch1.toCharArray()[0]))
						{
							// ȡ�á��������һ�γ��ֵ�λ��
							int y = result.lastIndexOf('(');
							// ���Ǵ����������ʽ�м��г˺Ż���ŵ���������硰1 + 2 ) * 3 - ��
							if (y != -1)
							{
								// �á��������˺Ż����֮ǰ��С���㵥Ԫ������
								result = result.substring(0, y) + '(' + result.substring(y, result.length()) + ch1;
								// ����ȡ����������������ջ
								s2.push(ch);
							}
							else
							{
								// ���Ǵ�����ʽ��ͷ�����������ֶ����ͬ���ȼ��������
								// ջ�Ǻ���ȳ��������Ƚ����ӽ���Ԫ�ص���������������
								String itemTmp = s1.pop();
								// �൱�ڴ�����ʽ�ĵ�һ��Ԫ��
								result = '(' + s1.pop() + ch1;
								// ���½����ӽ���Ԫ��ѹ�������ջ
								s1.push(itemTmp);
								// ������������ѹ�������ջ
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
					// �����������Ҳ�����ջ��Ϊ��ʱ���ֱ�Ӳ�����ջ�������ջ�е�������Ĳ������Ͷ�Ӧ����������Ҹ���������ӡ�����
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

	// �ж��Ƿ��ǲ�����
	private static boolean isOperand(String ch)
	{
		String[] operators = { "+", "-", "*", "/", "(", ")" };
		for (int i = 0; i < operators.length; i++)
			if (ch.equals(operators[i]))
				return false;
		return true;
	}

	// �ж��Ƿ��������
	private static boolean isOperand2(String ch)
	{
		String[] operators = { "+", "-", "*", "/" };
		for (int i = 0; i < operators.length; i++)
			if (ch.equals(operators[i]))
				return true;
		return false;
	}

	// ��������������ȼ�
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
