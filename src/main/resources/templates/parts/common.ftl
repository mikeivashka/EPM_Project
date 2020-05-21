<#macro page>
    <!DOCTYPE html>
    <html lang="en">
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>DietManager</title>
</head>
<body style="height: 100%">
<#include "nav.ftl">
<main class="text-center py-5">
    <div class="container">
    <#nested >
    </div>
</main>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">© 2019-2020 Dmitri & Mikhail</p>
    <ul class="list-inline">
        <li class="list-inline-item"><a href="https://getbootstrap.com/docs/4.5/examples/checkout/#">Privacy</a></li>
        <li class="list-inline-item"><a href="https://getbootstrap.com/docs/4.5/examples/checkout/#">Terms</a></li>
        <li class="list-inline-item"><a href="https://getbootstrap.com/docs/4.5/examples/checkout/#">Support</a></li>
    </ul>
</footer>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
</#macro>

