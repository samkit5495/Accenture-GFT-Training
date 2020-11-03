<%

int n=Integer.parseInt(request.getParameter("number"));

int i;
for(i=2;i<=n/2;i++){
	if(n%i==0){
		out.write("Not Prime");
		break;
	}
}

if(i==(n/2)+1){
	out.write("Is Prime");
}
%>