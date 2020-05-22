validateDateTextBox=function(b){isValidDateTextBox(b);var a=document.getElementById(b).getAttribute("required");if(a=="true"){isMissingDateTextBox(b);}};expandDateYear=function(h){var c=document.getElementById(h).getAttribute("displayformat");if(!c){c=defaultDateFormat;}if(c.indexOf("YYYY")!=-1){var b=50;
var f=document.getElementById(h).value;var e=new Array();e[1]=getDateBlock(f,1);e[2]=getDateBlock(f,2);e[3]=getDateBlock(f,3);if(!e[1]||!e[2]||!e[3]){return false;}if(c.substr(1,1)=="Y"){var a=1;}else{if(c.substr(7,1)=="Y"){var a=3;}else{return false;}}if(e[a].length==1){e[a]="000"+e[a];}else{if(e[a].length==2){if(e[a]<b){e[a]="20"+e[a];
}else{e[a]="19"+e[a];}}else{if(e[a].length==3){e[a]="0"+e[a];}else{if(e[a].length==4){return true;}}}}var g=c.replace(/D/g,"").replace(/M/g,"").replace(/Y/g,"").substr(0,1);var d=e[1]+g+e[2]+g+e[3];document.getElementById(h).value=d;}else{return false;}return true;};getDateBlock=function(d,e){var a="^(\\d+)[\\-|\\/|/|:|.|\\.](\\d+)[\\-|\\/|/|:|.|\\.](\\d+)$";
var c=new RegExp(a);if(!c.exec(d)){return false;}var b=new Array();b[1]=RegExp.$1;b[2]=RegExp.$2;b[3]=RegExp.$3;if(e==1||e=="1"){return b[1];}else{if(e==2||e=="2"){return b[2];}else{if(e==3||e=="3"){return b[3];}else{b;}}}};getTimeBlock=function(b,d){if(b.indexOf(".")==-1&&b.indexOf(":")==-1){return false;
}if(b.length!=5&&b.length!=8){return false;}var a="";var c=b.match(/(\d+)(\d+)/g);if(d==1||d=="1"){a=c[0];}else{if(d==2||d=="2"){a=c[1];}else{if(d==3||d=="3"){a=c[2];}else{a=c;}}}if((d==3||d=="3")&&typeof a=="undefined"){a="00";}return a;};isValidDateTextBox=function(c){var b=this.isValidDate(document.getElementById(c).value,document.getElementById(c).getAttribute("displayformat"));
var a=document.getElementById(c+"invalidSpan");if(b){a.style.display="none";}else{a.style.display="";}};isMissingDateTextBox=function(c){var b=document.getElementById(c).value.length==0;var a=document.getElementById(c+"missingSpan");if(b){a.style.display="";}else{a.style.display="none";}};isValidDate=function(g,e){var b=false;
if(e.indexOf("YYYY")!=-1||e.indexOf("%Y")!=-1){b=true;}var f=g.substring(0,(b?10:8));var a=g.substring((b?11:9),g.length);if(e.indexOf("%y")!=-1||e.indexOf("%Y")!=-1){b=false;}var d=e.substring(0,(b?10:8));var c=e.substring((b?11:9),e.length);if(a==null||a==""){a="00:00:00";}if(c==null||c==""){c="HH24:MI:SS";
}if(this.getDateTime(f,d,a,c)){return true;}else{return false;}};purgeDateFormat=function(a){a=a.replace("mm","MM").replace("dd","DD").replace("yyyy","YYYY");a=a.replace("mm","MM").replace("dd","DD").replace("yy","YY");a=a.replace("%D","%d").replace("%M","%m");a=a.replace("/","-").replace("/","-").replace("/","-");
a=a.replace(".","-").replace(".","-").replace(".","-");a=a.replace(":","-").replace(":","-").replace(":","-");return a;};getDateTime=function(a,c,b,e){var h=new Date(0,0,0);if(a.length==0){return h;}if(a==null&&c==null){a="1999-01-01";c="YYYY-MM-DD";}var g=new Array();var i=false;g[1]=getDateBlock(a,1);
g[2]=getDateBlock(a,2);g[3]=getDateBlock(a,3);if(!g[1]||!g[2]||!g[3]){return false;}if(!c){c=defaultDateFormat;}c=purgeDateFormat(c);if((b==null||b=="")&&(e==null||e=="")){b="00:00:00";e="HH24:MI:SS";}var f=new Array();f[1]=getTimeBlock(b,1);f[2]=getTimeBlock(b,2);f[3]=getTimeBlock(b,3);if(!f[1]||!f[2]||!f[3]){return false;
}if(f[1]>23||f[2]>59||f[3]>59){return false;}var d=function(l,m,j){var k;l=parseFloat(l,10);m=parseFloat(m,10);j=parseFloat(j,10);if(j<1||j>31){return false;}if(m<1||m>12){return false;}if(l<1||l>9999){return false;}k=new Date(l,m-1,j);if(j!==k.getDate()){return false;}return true;};switch(c){case"MM-DD-YYYY":case"YY-MM-DDDD":case"DD-MM-YYYY":case"%m-%d-%Y":case"%Y-%m-%d":case"%d-%m-%Y":i=true;
}switch(c){case"MM-DD-YYYY":case"MM-DD-YY":case"%m-%d-%Y":case"%m-%d-%y":if(!d(g[3],g[1],g[2])){return false;}h=new Date(parseFloat(g[3]),parseFloat(g[1])-1,parseFloat(g[2]),f[1],f[2],f[3]);if(i){h.setFullYear(g[3]);}return h;case"YYYY-MM-DD":case"YY-MM-DD":case"%Y-%m-%d":case"%y-%m-%d":if(!d(g[1],g[2],g[3])){return false;
}h=new Date(parseFloat(g[1]),parseFloat(g[2])-1,parseFloat(g[3]),f[1],f[2],f[3]);if(i){h.setFullYear(g[1]);}return h;case"DD-MM-YYYY":case"DD-MM-YY":case"%d-%m-%Y":case"%d-%m-%y":default:if(!d(g[3],g[2],g[1])){return false;}h=new Date(parseFloat(g[3]),parseFloat(g[2])-1,parseFloat(g[1]),f[1],f[2],f[3]);
if(i){h.setFullYear(g[3]);}return h;}return false;};getDate=function(b,a){return getDateTime(b,a,null,null);};getTime=function(a,b){return getDateTime(null,null,a,b);};function autoCompleteDate(m,d){if(!isTabPressed){try{if(getCaretPosition(m).start!=m.value.length){return;}}catch(e){}if(d==null||d==""){d=m.getAttribute("displayformat");
}d=getDateFormat(d);var n=m.value;var l=d.match(/%./g);var g=0,f=-1;var o="";var a=0;var k=d.indexOf(l[0])+l[0].length;var h=d.substring(k,k+1);var c="";k=d.indexOf("%H");if(k!=-1){c=d.substring(k+2,k+3);}while(n.charAt(g)){if(n.charAt(g)==h||n.charAt(g)==c||n.charAt(g)==" "){g++;continue;}if(a<=0){f++;
if(f>0){if(l[f]=="%H"){o+=" ";}else{if(l[f]=="%M"||l[f]=="%S"){o+=c;}else{o+=h;}}}switch(l[f]){case"%d":case"%e":o+=n.charAt(g);a=2;break;case"%m":o+=n.charAt(g);a=2;break;case"%Y":o+=n.charAt(g);a=4;break;case"%y":o+=n.charAt(g);a=2;break;case"%H":case"%I":case"%k":case"%l":o+=n.charAt(g);a=2;break;
case"%M":o+=n.charAt(g);a=2;break;case"%S":o+=n.charAt(g);a=2;break;}}else{o+=n.charAt(g);}a--;g++;}m.value=o;if(g>7&&(typeof(m.onchange)!="undefined")){m.onchange();}}}function CaretPosition(){var b=null;var a=null;}function getCaretPosition(b){var c=new CaretPosition();if(document.selection){b.focus();
var a=document.selection.createRange();var d=a.text.length;a.moveStart("character",-b.value.length);c.start=a.text.length-d;c.end=a.text.length;}else{if(b.selectionStart||b.selectionStart=="0"){c.start=b.selectionStart;c.end=b.selectionEnd;}}return(c);}