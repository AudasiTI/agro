<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
	<div class="two columns">
		<h5>Fazendas</h5>
		<ul class="side-nav">
			<c:forEach items="${fazendas}" var="fazenda">
				<li><a href="fazenda/${fazenda.id}">${fazenda.nome}</a></li>
			</c:forEach>
		</ul>
		<h5>Safras</h5>
		<ul class="side-nav">
			<c:forEach items="${safras}" var="safra">
				<li><a href="safra/${safra.id}">${safra.ano}</a></li>
			</c:forEach>
		</ul>
	</div>



</div>

