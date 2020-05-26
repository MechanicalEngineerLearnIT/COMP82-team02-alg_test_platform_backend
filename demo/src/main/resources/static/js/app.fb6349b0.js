(function(e){function t(t){for(var r,n,l=t[0],i=t[1],u=t[2],p=0,h=[];p<l.length;p++)n=l[p],Object.prototype.hasOwnProperty.call(s,n)&&s[n]&&h.push(s[n][0]),s[n]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(e[r]=i[r]);c&&c(t);while(h.length)h.shift()();return o.push.apply(o,u||[]),a()}function a(){for(var e,t=0;t<o.length;t++){for(var a=o[t],r=!0,l=1;l<a.length;l++){var i=a[l];0!==s[i]&&(r=!1)}r&&(o.splice(t--,1),e=n(n.s=a[0]))}return e}var r={},s={app:0},o=[];function n(t){if(r[t])return r[t].exports;var a=r[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,n),a.l=!0,a.exports}n.m=e,n.c=r,n.d=function(e,t,a){n.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},n.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},n.t=function(e,t){if(1&t&&(e=n(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(n.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)n.d(a,r,function(t){return e[t]}.bind(null,r));return a},n.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return n.d(t,"a",t),t},n.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},n.p="";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],i=l.push.bind(l);l.push=t,l=l.slice();for(var u=0;u<l.length;u++)t(l[u]);var c=i;o.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"034f":function(e,t,a){"use strict";var r=a("85ec"),s=a.n(r);s.a},"05e8":function(e,t,a){"use strict";var r=a("d29e"),s=a.n(r);s.a},1:function(e,t){},"2f77":function(e,t,a){},"3c54":function(e,t,a){"use strict";var r=a("5ceb"),s=a.n(r);s.a},"3d48":function(e,t,a){},"526d":function(e,t,a){},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var r,s=a("2b0e"),o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("el-container",{staticStyle:{height:"700px",border:"1px solid #eee"}},[a("el-aside",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"18%"}},[a("el-image",{staticStyle:{width:"100%",height:"15%"},attrs:{src:e.url,fit:e.fit}}),a("el-menu",{attrs:{router:"","default-openeds":["0"]}},e._l(e.$router.options.routes,(function(t,r){return t.show?a("el-submenu",{attrs:{index:r+""}},[a("template",{slot:"title"},[a("i",{staticClass:"el-icon-menu"}),e._v(e._s(t.name))]),e._l(t.children,(function(t,r){return a("el-menu-item",{class:e.$route.path==t.path?"is-active":"",attrs:{index:t.path}},[e._v(e._s(t.name))])}))],2):e._e()})),1)],1),a("el-container",[a("el-header",{staticStyle:{"text-align":"right","font-size":"12px"}},[""==this.global.userName?a("span",[a("el-button",{attrs:{type:"text"},on:{click:e.runLogin}},[e._v("Login")]),a("el-button",{attrs:{type:"text"},on:{click:e.runRegister}},[e._v("Register")])],1):a("span",[e._v(" Welcome "+e._s(this.global.userName)+" "),a("el-button",{attrs:{type:"text"},on:{click:e.runLogout}},[e._v("Logout")])],1)]),a("el-main",[a("router-view")],1)],1)],1),a("el-footer",{staticStyle:{"text-align":"right","font-size":"12px"},attrs:{height:"5%"}},[e._v("Copyright © 2020 The University of Melbourne. All rights reserved.")])],1)},n=[],l={data:function(){return{fit:"fill",url:"https://courseseeker.edu.au/assets/images/institutions/3036.png"}},methods:{runLogin:function(){this.$router.push({path:"/Login"})},runRegister:function(){this.$router.push({path:"/Register"})},runLogout:function(){this.global.userName="",location.reload()}}},i=l,u=(a("034f"),a("2877")),c=Object(u["a"])(i,o,n,!1,null,null,null),p=c.exports,h=a("8c4f"),d=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},m=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("h1",[e._v("User Guide")]),a("p",{staticStyle:{"text-align":"justify-all"}},[e._v("Welcome to our website. This is the testing platform for the research project of Authorship Verification conducted at the University of Melbourne. "),a("br"),a("br",{staticStyle:{"font-family":"'Times New Roman'"}}),e._v("By using this website, the user can test whether a specific text is written by an author by comparing with the known files written by the author applying the existing algorithm. "),a("br"),a("br"),e._v("Want to try out yourself? Follow these few steps below, you can test your own files and see the output within a just few minutes!! "),a("br"),a("br"),e._v("Step1: "),a("br"),e._v("You can register as a user by inputting your Email information and set up your password. You can always login this website using this account. "),a("br"),a("br"),e._v("Step2: "),a("br"),e._v("Click on “Try out Model” section of the menu on the left side. In this section, you can upload the known files and unknown files from your local computer. Also, you can choose the n-gram value as you like. Then after these steps are all done, you can click on the “Run” button and then you can see the output directly on the screen like this. "),a("br"),a("br"),e._v("Step3: "),a("br"),e._v("If you already login to the website, you can see all the results of your previous tests like this. Pretty easily and quickly, isn’t it? "),a("br"),a("br"),e._v("Sounds super easy, right? Now it is time for you to try it yourself. ")])])}],f={name:"Home",data:function(){return{}}},y=f,g=(a("3c54"),Object(u["a"])(y,d,m,!1,null,"71b17480",null)),b=g.exports,v=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("h1",[e._v("Test Your Model")]),a("div",[a("h1",[e._v("Please upload known files")]),a("uploader",{staticClass:"uploader-example",attrs:{options:e.known}},[a("uploader-unsupport"),a("uploader-drop",[a("p",[e._v("Drop files here to upload or")]),a("uploader-btn",[e._v("select files")]),a("uploader-btn",{attrs:{directory:!0}},[e._v("select folder")])],1),a("uploader-list")],1),a("br"),a("br"),a("h1",[e._v("Please upload unknown files")]),a("uploader",{staticClass:"uploader-example",attrs:{options:e.unknown}},[a("uploader-unsupport"),a("uploader-drop",[a("p",[e._v("Drop files here to upload or")]),a("uploader-btn",[e._v("select files")])],1),a("uploader-list")],1),a("br"),a("br")],1),a("h3",[e._v("Please enter n for n-gram in algorithm: ")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.message,expression:"message"}],attrs:{placeholder:"n-gram"},domProps:{value:e.message},on:{input:function(t){t.target.composing||(e.message=t.target.value)}}}),a("br"),a("br"),a("el-button",{attrs:{type:"primary",round:""},on:{click:e.runAlgorithm}},[e._v("Run the Algorithm")]),a("br"),[e._v(e._s(e.showdata))],a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]})],2)},w=[],x={name:"Test",created:function(){console.log(this.global.userName),""==this.global.userName&&this.$router.push({path:"/Login",query:{data:this.$route.path}})},methods:{runAlgorithm:function(){this.loading=!0;var e=this;console.log({userEmail:this.global.userName,n:this.message}),$.ajax({async:!1,url:"http://localhost:8181//runalgo",type:"POST",contentType:"application/x-www-form-urlencoded",dataType:"json",data:{userEmail:e.global.userName,n:this.message},success:function(t){e.loading=!1,console.log(t),e.$router.push({path:"/ResultPage",query:{data:t}})},error:function(e,t){console.log(e),console.log(t)}})}},data:function(){return{showdata:this.showdata,loading:!1,message:"",known:{target:"//localhost:8181//uploadKnown",testChunks:!1},unknown:{target:"//localhost:8181//uploadUnknown",testChunks:!1},attrs:{accept:"image/*"}}}},_=x,S=(a("863b"),Object(u["a"])(_,v,w,!1,null,"0d1afb86",null)),k=S.exports,T=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("router-view")],1)},P=[],C={name:"Index"},j=C,E=Object(u["a"])(j,T,P,!1,null,"191cfca7",null),D=E.exports,O=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a(e.currentView,{tag:"component",attrs:{data:e.barData,title:e.echarttitle,width:"1000",height:"400",category:e.categoryData,legend:e.legendData,seriesType:"bar"}}),a("p",[e._v(e._s(e.explanation))])],1)},A=[],N=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"r-echarts-line"},[a("div",{ref:"mychart",staticStyle:{width:"600px",height:"400px"},attrs:{id:"main"}})])])},I=[],R=(a("4160"),a("159b"),a("53ca")),F=a("2ef0"),L=a.n(F),H=a("313e"),W={name:"EChartStyle",props:{data:{required:!0,type:Object},title:{type:Object|String},theme:{type:String},width:String,height:String,barType:{type:String},category:{required:!0,type:Object},legend:{required:!0,type:Array},dataView:{type:Boolean},magicType:{type:Array|String},restore:{type:Boolean},saveAsImage:{type:Boolean},stack:{type:String},seriesType:{type:String}},data:function(){var e={text:"",subtext:"",left:"left",textStyle:{color:"#000000",fontStyle:"normal",fontWeight:"bold",fontFamily:"sans-serif",fontSize:18}},t=this.title;t&&("string"===typeof t?e.text=t:"object"===Object(R["a"])(t)&&(t.text&&(e.text=t.text),t.subtext&&(e.subtext=t.subtext),t.left&&(e.left=t.left),t.textStyle&&(t.textStyle.color&&(e.textStyle.color=t.textStyle.color),t.textStyle.fontStyle&&(e.textStyle.fontStyle=t.textStyle.fontStyle),t.textStyle.fontWeight&&(e.textStyle.fontWeight=t.textStyle.fontWeight),t.textStyle.fontFamily&&(e.textStyle.fontFamily=t.textStyle.fontFamily),t.textStyle.fontSize&&(e.textStyle.fontSize=t.textStyle.fontSize))));var a={theme:"light",renderer:"canvas",opts:{width:600,height:400}};this.theme&&(a.theme=this.theme),this.width&&(a.opts.width=parseInt(this.width)),this.height&&(a.opts.height=parseInt(this.height));var r="yAxis";this.barType&&(r=this.barType);var s={show:!1,feature:{mark:{show:!0},dataView:{show:!1,readOnly:!1},magicType:{show:!1,type:[]},restore:{show:!1},saveAsImage:{show:!1}}};return this.dataView&&(s.show=!0,s.feature.dataView.show=!0),this.magicType&&(s.show=!0,s.feature.magicType.show=!0,"string"===typeof this.magicType?s.feature.magicType.type=[this.magicType]:s.feature.magicType.type=this.magicType),this.restore&&(s.show=!0,s.feature.restore.show=!0),this.saveAsImage&&(s.show=!0,s.feature.saveAsImage.show=!0),{titleProperty:e,domProperty:a,type:r,toolboxProperty:s}},mounted:function(){this.setEchart()},methods:{setEchart:function(){var e=this,t=this.$refs.mychart;this.myChart=H.init(t,e.domProperty.theme,{width:e.domProperty.opts.width,height:e.domProperty.opts.height});var a={title:{text:e.titleProperty.text,subtext:e.titleProperty.subtext,left:e.titleProperty.left,textStyle:e.titleProperty.textStyle},tooltip:{trigger:"axis"},toolbox:this.toolboxProperty,legend:{data:this.legend},series:[{type:"bar"}]};if("xAxis"===this.type){var r={type:"value"};a.xAxis=r,a.yAxis=this.category}else if("yAxis"===this.type){var s={type:"value"};a.yAxis=s,a.xAxis=this.category}var o=this.data;o&&L.a.forEach(this.legend,(function(t){var r=L.a.get(o,t);if(console.log(t),L.a.hasIn(o,t)){var s={name:t,type:e.seriesType,data:r};e.stack&&(s.stack=e.stack),a.series.push(s)}})),this.myChart.setOption(a)}}},q=W,z=Object(u["a"])(q,N,I,!1,null,"5f8d9f0c",null),M=z.exports,U=[],V=[],Y=[],B={name:"ResultPage",data:function(){return{data:this.$route.query.data,resultData:{fileName:"fileName.txt",possibility:"0.8",submissionTime:"012-03-24 01:23:34.0"},barData:{possibility:U,threshold:V},focusType:1,currentView:M,categoryData:{data:Y},legendData:["possibility","threshold"],echarttitle:{text:"Result(%)",left:"right",textStyle:{color:"#FF0000",fontStyle:"normal",fontWeight:"bold",fontFamily:"sans-serif",fontSize:18}}}},methods:{},created:function(){for(var e in this.resultData=this.$route.query.data,console.log(this.resultData),this.resultData["probabilityTable"])U.push(100*this.resultData["probabilityTable"][e]["similarity"]),Y.push(this.resultData["probabilityTable"][e]["metricsName"]);for(var e in this.resultData["thresholdTable"])V.push(100*this.resultData["thresholdTable"][e]["threshold"]);this.resultData["explanation"]}},G=B,K=(a("fcbd"),Object(u["a"])(G,O,A,!1,null,null,null)),Z=K.exports,J=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a(e.currentView,{tag:"component",attrs:{data:e.barData,title:e.echarttitle,width:"1000",height:"400",category:e.categoryData,legend:e.legendData,seriesType:"bar"}})],1)},Q=[],X=[],ee=[],te=[],ae={created:function(){for(var e in $.ajax({url:"http://localhost:8181/runalgo",type:"post",async:!1,dataType:"json",data:{userEmail:"saakd@qq.com"},success:function(e){r=e},error:function(e,t){console.log(e),console.log(t)}}),console.log(r),r["probabilityTable"])X.push(100*r["probabilityTable"][e]["similarity"]),te.push(r["probabilityTable"][e]["metricsName"]);for(var e in r["thresholdTable"])ee.push(100*r["thresholdTable"][e]["threshold"])},name:"HelloWork",data:function(){return{barData:{possible:X,threshold:ee},focusType:1,currentView:M,categoryData:{data:te},legendData:["possible","threshold"],echarttitle:{text:"Result(%)",left:"right",textStyle:{color:"#FF0000",fontStyle:"normal",fontWeight:"bold",fontFamily:"sans-serif",fontSize:18}}}}},re=ae,se=Object(u["a"])(re,J,Q,!1,null,"2c6d8098",null),oe=se.exports,ne=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]}),a("h1",[e._v("History Page")]),"null"!=this.resultData[0]["fileName"]?a("el-table",{attrs:{data:this.resultData}},[a("el-table-column",{staticStyle:{width:"100%"},attrs:{prop:"submissionTime",label:"Submission Time"}}),a("el-table-column",{attrs:{prop:"fileName",label:"File Name"}}),a("el-table-column",{attrs:{prop:"possibility",label:"Result"}}),a("el-table-column",{attrs:{prop:"n_gram",label:"Parameter Value"}}),a("el-table-column",{attrs:{prop:"conclusion",label:"Conclusion"}})],1):a("div",[a("h1",[e._v(e._s(e.resultData))]),a("h1",[e._v("No Record")])])],1)},le=[],ie={name:"History",created:function(){if(""==this.global.userName)this.$router.push({path:"/Login",query:{data:this.$route.path}});else{this.loading=!0;var e=this;$.ajax({async:!1,url:"http://localhost:8181//getRecords",type:"POST",contentType:"application/x-www-form-urlencoded",dataType:"json",data:{userEmail:this.global.userName},success:function(t){e.loading=!1,console.log(t),e.resultData=t,"null"==e.resultData[0]["fileName"]&&alert("Empty History")},error:function(t,a){console.log(t),console.log(a),e.loading=!1}})}},data:function(){return{loading:!1,resultData:{fileName:"",possibility:"",submissionTime:"",n_gram:"",conclusion:""}}}},ue=ie,ce=Object(u["a"])(ue,ne,le,!1,null,"c1541ae8",null),pe=ce.exports,he=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("h1",[e._v("Please upload known files")]),a("uploader",{staticClass:"uploader-example",attrs:{options:e.known}},[a("uploader-unsupport"),a("uploader-drop",[a("p",[e._v("Drop files here to upload or")]),a("uploader-btn",[e._v("select files")]),a("uploader-btn",{attrs:{directory:!0}},[e._v("select folder")])],1),a("uploader-list")],1),a("br"),a("br"),a("h1",[e._v("Please upload unknown files")]),a("uploader",{staticClass:"uploader-example",attrs:{options:e.unknown}},[a("uploader-unsupport"),a("uploader-drop",[a("p",[e._v("Drop files here to upload or")]),a("uploader-btn",[e._v("select files")])],1),a("uploader-list")],1),a("br"),a("br"),a("el-button",{attrs:{type:"success",icon:"el-icon-check",circle:""},on:{click:e.nextPage}})],1)},de=[],me={data:function(){return{known:{target:"//localhost:8181//uploadKnown",testChunks:!1},unknown:{target:"//localhost:8181//uploadUnknown",testChunks:!1},attrs:{accept:"image/*"}}},methods:{nextPage:function(){this.$router.push({path:"/ResultPage",query:{data:this.$route.path}})}}},fe=me,ye=(a("9832"),Object(u["a"])(fe,he,de,!1,null,"829569c2",null)),ge=ye.exports,be=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"login",attrs:{clearfix:""}},[a("div",{staticClass:"login-wrap"},[a("el-row",{attrs:{type:"flex",justify:"center"}},[a("el-form",{ref:"loginForm",attrs:{model:e.user,"status-icon":"","label-width":"80px"}},[a("h3",[e._v("Login")]),a("hr"),a("el-form-item",{attrs:{prop:"username",label:"Email"}},[a("el-input",{attrs:{placeholder:"Please enter your email","prefix-icon":""},model:{value:e.user.username,callback:function(t){e.$set(e.user,"username",t)},expression:"user.username"}})],1),a("el-form-item",{attrs:{id:"password",prop:"password",label:"password"}},[a("el-input",{attrs:{"show-password":"",placeholder:"please enter your password"},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}})],1),a("router-link",{attrs:{to:"/Register"}},[e._v("SIGN UP")]),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-upload"},on:{click:function(t){return e.doLogin()}}},[e._v("LOGIN")])],1)],1)],1)],1)])},ve=[],we={name:"userEmail",papssword:"userPassword",data:function(){return{user:{username:"",password:""}}},created:function(){},methods:{doLogin:function(){var e=this;this.user.username?this.user.password?(console.log({userEmail:this.user.username,userPassword:this.user.password}),$.ajax({async:!1,url:"http://localhost:8181//login",type:"POST",contentType:"application/x-www-form-urlencoded",dataType:"text",data:{userEmail:this.user.username,userPassword:this.user.password},success:function(t){"true"===t?(e.$router.push({path:"/Home"}),e.global.userName=e.user.username):alert("Your username and password are not correct！")},error:function(e,t){console.log(e),console.log(t)}})):this.$message.error("Please enter your password！"):this.$message.error("Please enter your email！")}}},xe=we,_e=(a("05e8"),Object(u["a"])(xe,be,ve,!1,null,"6f33dc50",null)),Se=_e.exports,ke=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"login clearfix"},[a("div",{staticClass:"login-wrap"},[a("el-row",{attrs:{type:"flex",justify:"center"}},[a("el-form",{ref:"loginForm",attrs:{model:e.user,"status-icon":"","label-width":"80px"}},[a("h3",[e._v("Sign Up")]),a("hr"),a("el-form-item",{attrs:{prop:"email",label:"Email"}},[a("el-input",{attrs:{placeholder:"Please enter your Email"},model:{value:e.user.email,callback:function(t){e.$set(e.user,"email",t)},expression:"user.email"}})],1),a("el-form-item",{attrs:{prop:"password",label:"Password"}},[a("el-input",{attrs:{"show-password":"",placeholder:"Please enter your password"},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:""},on:{click:function(t){return e.doRegister()}}},[e._v("SIGN UP")])],1)],1)],1)],1)])},Te=[],Pe={name:"Register",data:function(){return{user:{email:"",password:""}}},created:function(){},methods:{doRegister:function(){var e=this;if(this.user.email){if(null!=this.user.email){var t=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;if(t.test(this.user.email)){if(!this.user.password)return void this.$message.error("Please enter password！");console.log({userEmail:this.user.email,userPassword:this.user.password}),$.ajax({async:!1,url:"http://localhost:8181//register",type:"POST",contentType:"application/x-www-form-urlencoded",dataType:"text",data:{userEmail:this.user.email,userPassword:this.user.password},success:function(t){console.log(t),"true"===t?e.$router.push({path:"/Login"}):alert("Your email has already existed！")},error:function(e,t){console.log(e),console.log(t)}})}else this.$message.error("Please enter valid Email Address！")}}else this.$message.error("Please enter your Email！")}}},$e=Pe,Ce=(a("7234"),Object(u["a"])($e,ke,Te,!1,null,"1052a4fd",null)),je=Ce.exports,Ee=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("h1",[e._v("Please Select Metrics You Want to Use? ")]),a("el-checkbox",{attrs:{indeterminate:e.isIndeterminate},on:{change:e.handleCheckAllChange},model:{value:e.checkAll,callback:function(t){e.checkAll=t},expression:"checkAll"}},[e._v("Select All")]),a("div",{staticStyle:{margin:"15px 0"}}),a("el-checkbox-group",{on:{change:e.handleCheckedCitiesChange},model:{value:e.checkedCities,callback:function(t){e.checkedCities=t},expression:"checkedCities"}},e._l(e.cities,(function(t){return a("el-checkbox",{key:t,attrs:{label:t}},[e._v(e._s(t))])})),1)],1)},De=[],Oe=["Cosine Similarity","Canberra Similarity","Euclidean Similarity","Keselj Similarity","Manhattan Similarity"],Ae={data:function(){return{checkAll:!1,checkedCities:["Cosine Similarity","Canberra Similarity"],cities:Oe,isIndeterminate:!0}},methods:{handleCheckAllChange:function(e){this.checkedCities=e?Oe:[],this.isIndeterminate=!1},handleCheckedCitiesChange:function(e){var t=e.length;this.checkAll=t===this.cities.length,this.isIndeterminate=t>0&&t<this.cities.length}}},Ne=Ae,Ie=Object(u["a"])(Ne,Ee,De,!1,null,"9cd5b10a",null),Re=Ie.exports,Fe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{type:"expand"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-form",{staticClass:"demo-table-expand",attrs:{"label-position":"left",inline:""}},[a("el-form-item",{attrs:{label:"商品名称"}},[a("span",[e._v(e._s(t.row.name))])]),a("el-form-item",{attrs:{label:"所属店铺"}},[a("span",[e._v(e._s(t.row.shop))])]),a("el-form-item",{attrs:{label:"商品 ID"}},[a("span",[e._v(e._s(t.row.id))])]),a("el-form-item",{attrs:{label:"店铺 ID"}},[a("span",[e._v(e._s(t.row.shopId))])]),a("el-form-item",{attrs:{label:"商品分类"}},[a("span",[e._v(e._s(t.row.category))])]),a("el-form-item",{attrs:{label:"店铺地址"}},[a("span",[e._v(e._s(t.row.address))])]),a("el-form-item",{attrs:{label:"商品描述"}},[a("span",[e._v(e._s(t.row.desc))])])],1)]}}])}),a("el-table-column",{attrs:{label:"商品 ID",prop:"id"}}),a("el-table-column",{attrs:{label:"商品名称",prop:"name"}}),a("el-table-column",{attrs:{label:"描述",prop:"desc"}})],1)},Le=[],He={name:"newTesing",data:function(){return{tableData:[{id:"12987122",name:"好滋好味鸡蛋仔",category:"江浙小吃、小吃零食",desc:"荷兰优质淡奶，奶香浓而不腻",address:"上海市普陀区真北路",shop:"王小虎夫妻店",shopId:"10333"},{id:"12987123",name:"好滋好味鸡蛋仔",category:"江浙小吃、小吃零食",desc:"荷兰优质淡奶，奶香浓而不腻",address:"上海市普陀区真北路",shop:"王小虎夫妻店",shopId:"10333"},{id:"12987125",name:"好滋好味鸡蛋仔",category:"江浙小吃、小吃零食",desc:"荷兰优质淡奶，奶香浓而不腻",address:"上海市普陀区真北路",shop:"王小虎夫妻店",shopId:"10333"},{id:"12987126",name:"好滋好味鸡蛋仔",category:"江浙小吃、小吃零食",desc:"荷兰优质淡奶，奶香浓而不腻",address:"上海市普陀区真北路",shop:"王小虎夫妻店",shopId:"10333"}]}}},We=He,qe=(a("ee7c"),Object(u["a"])(We,Fe,Le,!1,null,null,null)),ze=qe.exports;s["default"].use(h["a"]);var Me=[{show:!0,path:"/",name:"Testing Platform",component:D,redirect:"/Home",children:[{path:"/Home",name:"Home",component:b},{path:"/Test",name:"Try Out Model",component:k},{path:"/History",name:"Review the History",component:pe}]},{path:"/ResultPage",name:"ResultPage",component:Z,props:!0,show:!1},{path:"/EChartStyle",name:"EChartStyle",component:M,props:!0,show:!1},{path:"/HelloWork",name:"HelloWork",component:oe,props:!0,show:!1},{path:"/UploadFiles",name:"UploadFiles",component:ge,props:!0,show:!1},{path:"/Login",name:"Login",component:Se,props:!0,show:!1},{path:"/Register",name:"Register",component:je,props:!0,show:!1},{path:"/Progress",name:"Progress",component:Re,props:!0,show:!1},{path:"/newTesting",name:"newTesting",component:ze,props:!0,show:!1}],Ue=new h["a"]({base:"",routes:Me}),Ve=Ue,Ye=a("2f62");s["default"].use(Ye["a"]);var Be=new Ye["a"].Store({state:{},mutations:{},actions:{},modules:{}}),Ge=a("bc3a"),Ke=a.n(Ge),Ze=a("28dd"),Je=a("5c96"),Qe=a.n(Je);a("0fae");s["default"].use(Qe.a);var Xe=a("5b7e"),et=a.n(Xe),tt=a("ef55"),at=a.n(tt),rt="",st={userName:rt};s["default"].use(Ze["a"]),s["default"].use(at.a),s["default"].config.productionTip=!1,s["default"].prototype.$axios=Ke.a,s["default"].prototype.global=st,new s["default"]({router:Ve,store:Be,render:function(e){return e(p)},components:{Spinner:et.a}}).$mount("#app")},"5ceb":function(e,t,a){},7234:function(e,t,a){"use strict";var r=a("3d48"),s=a.n(r);s.a},"7e0f":function(e,t,a){},"820e":function(e,t,a){},"85ec":function(e,t,a){},"863b":function(e,t,a){"use strict";var r=a("7e0f"),s=a.n(r);s.a},9832:function(e,t,a){"use strict";var r=a("820e"),s=a.n(r);s.a},d29e:function(e,t,a){},ee7c:function(e,t,a){"use strict";var r=a("2f77"),s=a.n(r);s.a},fcbd:function(e,t,a){"use strict";var r=a("526d"),s=a.n(r);s.a}});
//# sourceMappingURL=app.fb6349b0.js.map