import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class collection {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		List<Person> al=new ArrayList<Person>(10);

		while(true) {
			System.out.println("1. Add data  \n2. Fetch data  \n3. Remove data  \n4. Print data	 \n5. Quit");
			int choose = Integer.parseInt(br.readLine());
			int exit = 0;

			switch(choose)
			{
				case 1:
				{
					System.out.println("Enter the name and age of the person to be added to the list");
					String[] inputData = br.readLine().split(" ");
					String name = inputData[0];
					int age = Integer.parseInt(inputData[1]);
					al.add(new Person(age,name));
					break;
				}
				case 2:
					{
						System.out.println("Enter the name of the person whose age has to be found");
						String name = br.readLine();
						int flag = 0;
						Iterator<Person> it = al.iterator();
						while(it.hasNext())
						{
							Person person = it.next();
							if(person.name.equals(name))
							{
								System.out.println("Age of "+name+" is " + person.age);
								flag = 1;
								break;
							}
						}
						if(flag == 0)
						{
							System.out.println("Person with the name "+name+" not found");
						}
						break;
					}

				case 3:
					{
						System.out.println("Enter name of person to be removed from the list");
						String name = br.readLine();
						int del = -1, index = 0;
						Iterator<Person> it = al.iterator();
						while(it.hasNext())
						{
							Person person = it.next();
							if(person.name.equals(name))
							{
								del = index;
								break;
							}
							index++;
						}
						if(del == -1)
						{
							System.out.println("Person with name " + name + " not found");
						}
						else
						{
							al.remove(del);
						}
						break;
					}

				case 4:
					{
						Iterator<Person> it = al.iterator();
						int i = 1;
						while(it.hasNext())
						{
							Person person = it.next();
							System.out.println("Data at position: " + i + ", Name: " + person.name + ", Age: " + person.age);
							i+=1;
						}
						break;
					}
				case 5:
					{
						exit=1;
						break;
					}
			}
			if(exit==1)
			{
				break;
			}
		}
	}
}
