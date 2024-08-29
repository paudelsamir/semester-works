//Design a DFA recognizing strings of {a,b}  ending with a.
// Implement it in C/C++ program
#include <iostream>
#include <conio.h>

#define TOTAL_STATES 2
#define FINAL_STATES 1
#define ALPHABET_CHARCTERS 2

#define ERROR 0
#define NO_FINAL_STATE 1
#define FINAL 2

using namespace std;
enum ALPHABETS {a,b};
enum DFA_STATES{q0,q1};
int Accepted_states[FINAL_STATES]={q1};
char alphabet[ALPHABET_CHARCTERS]={'a','b'};
int Transition_Table[TOTAL_STATES][ALPHABET_CHARCTERS];
int current_state=q0;

//Transition table of DFA
void DefineDFA()
{
    Transition_Table[q0][a] = q1;
    Transition_Table[q0][b] = q0;
    Transition_Table[q1][a] = q1;
    Transition_Table[q1][b] = q0;
  }
//simulating DFA above
int MoveDFA(char current_symb)
{
	int i,pos;
    for(pos=0;pos<ALPHABET_CHARCTERS; pos++)
        if(current_symb==alphabet[pos])
            break;// break loop if character is '0' or '1'
    if(pos==ALPHABET_CHARCTERS)
         return ERROR;    // returns Error code if other than '0' or '1'
    current_state=Transition_Table[current_state][pos];
    for(i=0;i<FINAL_STATES;i++)
    {
    	if(current_state==Accepted_states[i])
            return FINAL;
	}
 	return NO_FINAL_STATE;
}

int main()
{
    char string[100];
    int result;
    char ch;

    DefineDFA();    //Fill transition table
	do{
		current_state=q0;
		cout<<"Enter a string with 'a' s and 'b's (Press Enter to Stop):"<<endl;
	    cin>>string;
	    int i=0;
	 	while(string[i]!= '\0')
	    {
		  result= MoveDFA(string[i]);
		  if(result==ERROR)
	           break;
	      i++;
		}
	    switch (result)
		{
	    	case ERROR: cout<<"Unknown Symbol-"<<string[i]<<endl;
	            break;
	    	case NO_FINAL_STATE: cout<<"Not accepted";
				break;
	    	case FINAL: cout<<"Accepted";
				break;
	    	default: cout<<"Unknown Error";
	    }
	    cout<<endl<<endl;
	    cout<<"Do you want to continue!(y/n): ";
	    cin>>ch;
	}while(ch=='Y'||ch=='y');
	return 0;
}


