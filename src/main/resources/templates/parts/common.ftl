<#macro page>
    <!DOCTYPE html>
    <html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <link
            rel="stylesheet"
            type="text/css"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="https://unpkg.com/aos@2.3.1/dist/aos.css" />
    <link href="css/Main.css" rel="stylesheet">
    <link href="css/fonts.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">

    <script type="text/javascript" src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script type="text/javascript" src="https://unpkg.com/headroom.js@0.12.0/dist/headroom.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>DietManager</title>
</head>
<body style="display: flex; flex-direction: column; height: 100%">
<#include "nav.ftl">
<main class="text-center py-5">
    <div class="container">
    <#nested >
    </div>
</main>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">© 2022 Mikhail Ivashka</p>
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

