#include<iostream>
#include<string.h>
using namespace std;
class treenode
{public:
	treenode *lchild;treenode *rchild;int data;

		treenode(int element=0)
		{data=element;lchild=NULL;rchild=NULL;}
		treenode* insert(int,treenode*);
		
		int depth(treenode*);

};
int treenode::depth(treenode* ptr)
{
int ldepth=0,rdepth=0;
if (ptr==NULL)return 0;
else
{
	ldepth=depth(ptr->lchild);
	rdepth=depth(ptr->rchild);
	if (ldepth>rdepth) return (ldepth+1);else return (rdepth+1);}}
  
  int main()
{int ch,item;treenode g;char c;c='y';
while(c=='y')
{
cout<<"1.insert 2.depth ";
cin>>ch;
switch(ch)
{
case 1: cout<<"Enter ele to be inserted";
cin>>item;
root=g.insert(item,root);
break;

case 2: cout<<g.depth(root);break;

}
cout<<"continue?";
cin>>c;
}
}
