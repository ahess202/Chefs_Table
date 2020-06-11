window.addEventListener('load', (event) => {

const app = document.getElementById('root')

const logo = document.createElement('img')
logo.src = 'logo.png'

const container = document.createElement('div')
container.setAttribute('class', 'container')

app.appendChild(logo)
app.appendChild(container)

var request = new XMLHttpRequest()
request.open('GET', 'https://api.nytimes.com/svc/topstories/v2/food.json?api-key=0KaBAGFOKItJ0ztrTYDlJ0751NHxkwTD', true)
request.onload = function() {
  // Begin accessing JSON data here
  var data = JSON.parse(this.response)
  if (request.status >= 200 && request.status < 400) {
    data.results.forEach(article => {
      const card = document.createElement('div')
      card.setAttribute('class', 'card')

      const h1 = document.createElement('h1')
      h1.textContent = article.title

      const p = document.createElement('p')
      article.byline = article.byline.substring(0, 300)
      p.textContent = `${article.byline}...`

      container.appendChild(card)
      card.appendChild(h1)
      card.appendChild(p)
    })
  } else {
    const errorMessage = document.createElement('marquee')
    errorMessage.textContent = `Gah, it's not working!`
    app.appendChild(errorMessage)
  }
}

request.send()

//fetch('https://api.nytimes.com/svc/topstories/v2/food.json?api-key=0KaBAGFOKItJ0ztrTYDlJ0751NHxkwTD')
//  .then(response => {
//    return response.json()
//  })
//  .then(data => {
//    console.log(data)
//    var dataParsed = JSON.parse(this.response)
//
//    dataParsed.forEach(results => {
//      // Log each movie's title
//      console.log(result.title)
//    })
//  })
//  .catch(err => {
//    // Do something for an error here
//  })
//  const app = document.getElementById('root')

});
