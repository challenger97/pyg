/*
 Highcharts JS v7.0.1 (2018-12-19)
 Old IE (v6, v7, v8) module for Highcharts v6+.

 (c) 2010-2018 Highsoft AS
 Author: Torstein Honsi

 License: www.highcharts.com/license
*/
(function(k){"object"===typeof module&&module.exports?module.exports=k:"function"===typeof define&&define.amd?define(function(){return k}):k("undefined"!==typeof Highcharts?Highcharts:void 0)})(function(k){(function(d){var k,h;h=d.Chart;var A=d.createElement,w=d.css,D=d.defined,p=d.deg2rad,E=d.discardElement,f=d.doc,F=d.erase,x=d.extend;k=d.extendClass;var M=d.isArray,G=d.isNumber,B=d.isObject,N=d.merge,L=d.noop,y=d.pick,q=d.pInt,C=d.svg,v=d.SVGElement,t=d.SVGRenderer,u=d.win,O=d.wrap;d.getOptions().global.VMLRadialGradientURL=
    "http://code.highcharts.com/7.0.1/gfx/vml-radial-gradient.png";f&&!f.defaultView&&(d.getStyle=function(a,b){var c={width:"clientWidth",height:"clientHeight"}[b];if(a.style[b])return d.pInt(a.style[b]);"opacity"===b&&(b="filter");if(c)return a.style.zoom=1,Math.max(a[c]-2*d.getStyle(a,"padding"),0);a=a.currentStyle[b.replace(/\-(\w)/g,function(a,b){return b.toUpperCase()})];"filter"===b&&(a=a.replace(/alpha\(opacity=([0-9]+)\)/,function(a,b){return b/100}));return""===a?1:d.pInt(a)});C||(O(d.SVGRenderer.prototype,
    "text",function(a){return a.apply(this,Array.prototype.slice.call(arguments,1)).css({position:"absolute"})}),d.Pointer.prototype.normalize=function(a,b){a=a||u.event;a.target||(a.target=a.srcElement);b||(this.chartPosition=b=d.offset(this.chart.container));return d.extend(a,{chartX:Math.round(Math.max(a.x,a.clientX-b.left)),chartY:Math.round(a.y)})},h.prototype.ieSanitizeSVG=function(a){return a=a.replace(/<IMG /g,"\x3cimage ").replace(/<(\/?)TITLE>/g,"\x3c$1title\x3e").replace(/height=([^" ]+)/g,
    'height\x3d"$1"').replace(/width=([^" ]+)/g,'width\x3d"$1"').replace(/hc-svg-href="([^"]+)">/g,'xlink:href\x3d"$1"/\x3e').replace(/ id=([^" >]+)/g,' id\x3d"$1"').replace(/class=([^" >]+)/g,'class\x3d"$1"').replace(/ transform /g," ").replace(/:(path|rect)/g,"$1").replace(/style="([^"]+)"/g,function(a){return a.toLowerCase()})},h.prototype.isReadyToRender=function(){var a=this;return C||u!=u.top||"complete"===f.readyState?!0:(f.attachEvent("onreadystatechange",function(){f.detachEvent("onreadystatechange",
    a.firstRender);"complete"===f.readyState&&a.firstRender()}),!1)},f.createElementNS||(f.createElementNS=function(a,b){return f.createElement(b)}),d.addEventListenerPolyfill=function(a,b){function c(a){a.target=a.srcElement||u;b.call(e,a)}var e=this;e.attachEvent&&(e.hcEventsIE||(e.hcEventsIE={}),b.hcKey||(b.hcKey=d.uniqueKey()),e.hcEventsIE[b.hcKey]=c,e.attachEvent("on"+a,c))},d.removeEventListenerPolyfill=function(a,b){this.detachEvent&&(b=this.hcEventsIE[b.hcKey],this.detachEvent("on"+a,b))},h={docMode8:f&&
    8===f.documentMode,init:function(a,b){var c=["\x3c",b,' filled\x3d"f" stroked\x3d"f"'],e=["position: ","absolute",";"],l="div"===b;("shape"===b||l)&&e.push("left:0;top:0;width:1px;height:1px;");e.push("visibility: ",l?"hidden":"visible");c.push(' style\x3d"',e.join(""),'"/\x3e');b&&(c=l||"span"===b||"img"===b?c.join(""):a.prepVML(c),this.element=A(c));this.renderer=a},add:function(a){var b=this.renderer,c=this.element,e=b.box,l=a&&a.inverted,e=a?a.element||a:e;a&&(this.parentGroup=a);l&&b.invertChild(c,
        e);e.appendChild(c);this.added=!0;this.alignOnAdd&&!this.deferUpdateTransform&&this.updateTransform();if(this.onAdd)this.onAdd();this.className&&this.attr("class",this.className);return this},updateTransform:v.prototype.htmlUpdateTransform,setSpanRotation:function(){var a=this.rotation,b=Math.cos(a*p),c=Math.sin(a*p);w(this.element,{filter:a?["progid:DXImageTransform.Microsoft.Matrix(M11\x3d",b,", M12\x3d",-c,", M21\x3d",c,", M22\x3d",b,", sizingMethod\x3d'auto expand')"].join(""):"none"})},getSpanCorrection:function(a,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   b,c,e,l){var d=e?Math.cos(e*p):1,J=e?Math.sin(e*p):0,r=y(this.elemHeight,this.element.offsetHeight),f;this.xCorr=0>d&&-a;this.yCorr=0>J&&-r;f=0>d*J;this.xCorr+=J*b*(f?1-c:c);this.yCorr-=d*b*(e?f?c:1-c:1);l&&"left"!==l&&(this.xCorr-=a*c*(0>d?-1:1),e&&(this.yCorr-=r*c*(0>J?-1:1)),w(this.element,{textAlign:l}))},pathToVML:function(a){for(var b=a.length,c=[];b--;)G(a[b])?c[b]=Math.round(10*a[b])-5:"Z"===a[b]?c[b]="x":(c[b]=a[b],!a.isArc||"wa"!==a[b]&&"at"!==a[b]||(c[b+5]===c[b+7]&&(c[b+7]+=a[b+7]>a[b+
    5]?1:-1),c[b+6]===c[b+8]&&(c[b+8]+=a[b+8]>a[b+6]?1:-1)));return c.join(" ")||"x"},clip:function(a){var b=this,c;a?(c=a.members,F(c,b),c.push(b),b.destroyClip=function(){F(c,b)},a=a.getCSS(b)):(b.destroyClip&&b.destroyClip(),a={clip:b.docMode8?"inherit":"rect(auto)"});return b.css(a)},css:v.prototype.htmlCss,safeRemoveChild:function(a){a.parentNode&&E(a)},destroy:function(){this.destroyClip&&this.destroyClip();return v.prototype.destroy.apply(this)},on:function(a,b){this.element["on"+a]=function(){var a=
        u.event;a.target=a.srcElement;b(a)};return this},cutOffPath:function(a,b){var c;a=a.split(/[ ,]/);c=a.length;if(9===c||11===c)a[c-4]=a[c-2]=q(a[c-2])-10*b;return a.join(" ")},shadow:function(a,b,c){var e=[],d,g=this.element,f=this.renderer,r,h=g.style,m,H=g.path,K,n,k,p;H&&"string"!==typeof H.value&&(H="x");n=H;if(a){k=y(a.width,3);p=(a.opacity||.15)/k;for(d=1;3>=d;d++)K=2*k+1-2*d,c&&(n=this.cutOffPath(H.value,K+.5)),m=['\x3cshape isShadow\x3d"true" strokeweight\x3d"',K,'" filled\x3d"false" path\x3d"',
        n,'" coordsize\x3d"10 10" style\x3d"',g.style.cssText,'" /\x3e'],r=A(f.prepVML(m),null,{left:q(h.left)+y(a.offsetX,1),top:q(h.top)+y(a.offsetY,1)}),c&&(r.cutOff=K+1),m=['\x3cstroke color\x3d"',a.color||"#000000",'" opacity\x3d"',p*d,'"/\x3e'],A(f.prepVML(m),null,null,r),b?b.element.appendChild(r):g.parentNode.insertBefore(r,g),e.push(r);this.shadows=e}return this},updateShadows:L,setAttr:function(a,b){this.docMode8?this.element[a]=b:this.element.setAttribute(a,b)},getAttr:function(a){return this.docMode8?
        this.element[a]:this.element.getAttribute(a)},classSetter:function(a){(this.added?this.element:this).className=a},dashstyleSetter:function(a,b,c){(c.getElementsByTagName("stroke")[0]||A(this.renderer.prepVML(["\x3cstroke/\x3e"]),null,null,c))[b]=a||"solid";this[b]=a},dSetter:function(a,b,c){var e=this.shadows;a=a||[];this.d=a.join&&a.join(" ");c.path=a=this.pathToVML(a);if(e)for(c=e.length;c--;)e[c].path=e[c].cutOff?this.cutOffPath(a,e[c].cutOff):a;this.setAttr(b,a)},fillSetter:function(a,b,c){var e=
        c.nodeName;"SPAN"===e?c.style.color=a:"IMG"!==e&&(c.filled="none"!==a,this.setAttr("fillcolor",this.renderer.color(a,c,b,this)))},"fill-opacitySetter":function(a,b,c){A(this.renderer.prepVML(["\x3c",b.split("-")[0],' opacity\x3d"',a,'"/\x3e']),null,null,c)},opacitySetter:L,rotationSetter:function(a,b,c){c=c.style;this[b]=c[b]=a;c.left=-Math.round(Math.sin(a*p)+1)+"px";c.top=Math.round(Math.cos(a*p))+"px"},strokeSetter:function(a,b,c){this.setAttr("strokecolor",this.renderer.color(a,c,b,this))},"stroke-widthSetter":function(a,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b,c){c.stroked=!!a;this[b]=a;G(a)&&(a+="px");this.setAttr("strokeweight",a)},titleSetter:function(a,b){this.setAttr(b,a)},visibilitySetter:function(a,b,c){"inherit"===a&&(a="visible");this.shadows&&this.shadows.forEach(function(c){c.style[b]=a});"DIV"===c.nodeName&&(a="hidden"===a?"-999em":0,this.docMode8||(c.style[b]=a?"visible":"hidden"),b="top");c.style[b]=a},xSetter:function(a,b,c){this[b]=a;"x"===b?b="left":"y"===b&&(b="top");this.updateClipping?(this[b]=a,this.updateClipping()):c.style[b]=a},
    zIndexSetter:function(a,b,c){c.style[b]=a},fillGetter:function(){return this.getAttr("fillcolor")||""},strokeGetter:function(){return this.getAttr("strokecolor")||""},classGetter:function(){return this.getAttr("className")||""}},h["stroke-opacitySetter"]=h["fill-opacitySetter"],d.VMLElement=h=k(v,h),h.prototype.ySetter=h.prototype.widthSetter=h.prototype.heightSetter=h.prototype.xSetter,h={Element:h,isIE8:-1<u.navigator.userAgent.indexOf("MSIE 8.0"),init:function(a,b,c){var e,d;this.alignedObjects=
        [];e=this.createElement("div").css({position:"relative"});d=e.element;a.appendChild(e.element);this.isVML=!0;this.box=d;this.boxWrapper=e;this.gradients={};this.cache={};this.cacheKeys=[];this.imgCount=0;this.setSize(b,c,!1);if(!f.namespaces.hcv){f.namespaces.add("hcv","urn:schemas-microsoft-com:vml");try{f.createStyleSheet().cssText="hcv\\:fill, hcv\\:path, hcv\\:shape, hcv\\:stroke{ behavior:url(#default#VML); display: inline-block; } "}catch(g){f.styleSheets[0].cssText+="hcv\\:fill, hcv\\:path, hcv\\:shape, hcv\\:stroke{ behavior:url(#default#VML); display: inline-block; } "}}},
    isHidden:function(){return!this.box.offsetWidth},clipRect:function(a,b,c,e){var d=this.createElement(),g=B(a);return x(d,{members:[],count:0,left:(g?a.x:a)+1,top:(g?a.y:b)+1,width:(g?a.width:c)-1,height:(g?a.height:e)-1,getCSS:function(a){var b=a.element,c=b.nodeName,e=a.inverted,d=this.top-("shape"===c?b.offsetTop:0),l=this.left,b=l+this.width,g=d+this.height,d={clip:"rect("+Math.round(e?l:d)+"px,"+Math.round(e?g:b)+"px,"+Math.round(e?b:g)+"px,"+Math.round(e?d:l)+"px)"};!e&&a.docMode8&&"DIV"===c&&
        x(d,{width:b+"px",height:g+"px"});return d},updateClipping:function(){d.members.forEach(function(a){a.element&&a.css(d.getCSS(a))})}})},color:function(a,b,c,e){var l=this,g,f=/^rgba/,r,h,m="none";a&&a.linearGradient?h="gradient":a&&a.radialGradient&&(h="pattern");if(h){var k,p,n=a.linearGradient||a.radialGradient,q,t,u,w,y,v="";a=a.stops;var x,B=[],C=function(){r=['\x3cfill colors\x3d"'+B.join(",")+'" opacity\x3d"',u,'" o:opacity2\x3d"',t,'" type\x3d"',h,'" ',v,'focus\x3d"100%" method\x3d"any" /\x3e'];
        A(l.prepVML(r),null,null,b)};q=a[0];x=a[a.length-1];0<q[0]&&a.unshift([0,q[1]]);1>x[0]&&a.push([1,x[1]]);a.forEach(function(a,b){f.test(a[1])?(g=d.color(a[1]),k=g.get("rgb"),p=g.get("a")):(k=a[1],p=1);B.push(100*a[0]+"% "+k);b?(u=p,w=k):(t=p,y=k)});if("fill"===c)if("gradient"===h)c=n.x1||n[0]||0,a=n.y1||n[1]||0,q=n.x2||n[2]||0,n=n.y2||n[3]||0,v='angle\x3d"'+(90-180*Math.atan((n-a)/(q-c))/Math.PI)+'"',C();else{var m=n.r,D=2*m,E=2*m,F=n.cx,G=n.cy,I=b.radialReference,z,m=function(){I&&(z=e.getBBox(),
        F+=(I[0]-z.x)/z.width-.5,G+=(I[1]-z.y)/z.height-.5,D*=I[2]/z.width,E*=I[2]/z.height);v='src\x3d"'+d.getOptions().global.VMLRadialGradientURL+'" size\x3d"'+D+","+E+'" origin\x3d"0.5,0.5" position\x3d"'+F+","+G+'" color2\x3d"'+y+'" ';C()};e.added?m():e.onAdd=m;m=w}else m=k}else f.test(a)&&"IMG"!==b.tagName?(g=d.color(a),e[c+"-opacitySetter"](g.get("a"),c,b),m=g.get("rgb")):(m=b.getElementsByTagName(c),m.length&&(m[0].opacity=1,m[0].type="solid"),m=a);return m},prepVML:function(a){var b=this.isIE8;a=
        a.join("");b?(a=a.replace("/\x3e",' xmlns\x3d"urn:schemas-microsoft-com:vml" /\x3e'),a=-1===a.indexOf('style\x3d"')?a.replace("/\x3e",' style\x3d"display:inline-block;behavior:url(#default#VML);" /\x3e'):a.replace('style\x3d"','style\x3d"display:inline-block;behavior:url(#default#VML);')):a=a.replace("\x3c","\x3chcv:");return a},text:t.prototype.html,path:function(a){var b={coordsize:"10 10"};M(a)?b.d=a:B(a)&&x(b,a);return this.createElement("shape").attr(b)},circle:function(a,b,c){var e=this.symbol("circle");
        B(a)&&(c=a.r,b=a.y,a=a.x);e.isCircle=!0;e.r=c;return e.attr({x:a,y:b})},g:function(a){var b;a&&(b={className:"highcharts-"+a,"class":"highcharts-"+a});return this.createElement("div").attr(b)},image:function(a,b,c,e,d){var g=this.createElement("img").attr({src:a});1<arguments.length&&g.attr({x:b,y:c,width:e,height:d});return g},createElement:function(a){return"rect"===a?this.symbol(a):t.prototype.createElement.call(this,a)},invertChild:function(a,b){var c=this;b=b.style;var e="IMG"===a.tagName&&a.style;
        w(a,{flip:"x",left:q(b.width)-(e?q(e.top):1),top:q(b.height)-(e?q(e.left):1),rotation:-90});a.childNodes.forEach(function(b){c.invertChild(b,a)})},symbols:{arc:function(a,b,c,e,d){var g=d.start,f=d.end,l=d.r||c||e;c=d.innerR;e=Math.cos(g);var h=Math.sin(g),m=Math.cos(f),k=Math.sin(f);if(0===f-g)return["x"];g=["wa",a-l,b-l,a+l,b+l,a+l*e,b+l*h,a+l*m,b+l*k];d.open&&!c&&g.push("e","M",a,b);g.push("at",a-c,b-c,a+c,b+c,a+c*m,b+c*k,a+c*e,b+c*h,"x","e");g.isArc=!0;return g},circle:function(a,b,c,e,d){d&&
        D(d.r)&&(c=e=2*d.r);d&&d.isCircle&&(a-=c/2,b-=e/2);return["wa",a,b,a+c,b+e,a+c,b+e/2,a+c,b+e/2,"e"]},rect:function(a,b,c,d,f){return t.prototype.symbols[D(f)&&f.r?"callout":"square"].call(0,a,b,c,d,f)}}},d.VMLRenderer=k=function(){this.init.apply(this,arguments)},k.prototype=N(t.prototype,h),d.Renderer=k);t.prototype.getSpanWidth=function(a,b){var c=a.getBBox(!0).width;!C&&this.forExport&&(c=this.measureSpanWidth(b.firstChild.data,a.styles));return c};t.prototype.measureSpanWidth=function(a,b){var c=
    f.createElement("span");a=f.createTextNode(a);c.appendChild(a);w(c,b);this.box.appendChild(c);b=c.offsetWidth;E(c);return b}})(k)});
//# sourceMappingURL=oldie.js.map