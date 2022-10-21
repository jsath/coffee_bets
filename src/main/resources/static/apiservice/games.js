
const $ = selector => document.querySelector(selector); 

const newsByDate = "https://api.sportsdata.io/v3/nba/scores/json/GamesByDate/";

const key = "key=f6386ba0dce143fe8681fe3ce97be569"


const monthNames = ["JAN", "FEB", "MAR", "APR", "MAY", "Jun",
  "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"
];


document.addEventListener("DOMContentLoaded", () => {
	var onLoadInput = $("#dateInput").value;
	const onLoad = new Date(onLoadInput)
	var onLoadApi = $("#dateInput").value.split("-")
	onLoadApi[1] = monthNames[onLoad.getMonth()]
    onLoadApi = onLoadApi.join("-");
    populate(onLoadApi)
    

    
	
	$("#dateInput").addEventListener("change", function() {
    var input = this.value;
    const d = new Date(input);
    var apiDate = input.split("-");
    apiDate[1] = monthNames[d.getMonth()]
    apiDate = apiDate.join("-");
    if(d < onLoad){
		getScores(apiDate)
	}else{
		populate(apiDate)
	}

    });

});


async function getScores(apiDate){
    const response = await fetch(newsByDate + apiDate + "?" + key);
    const data = await response.json();
    return gameResults(data);
}

async function populate(apiDate){
    const response = await fetch(newsByDate + apiDate + "?" + key);
    const data = await response.json();
    return gameDay(data);
}






async function gameDay(data){
	content = '';
	for(var i = 0; i < data.length; i++){
		content += "<div class='card text-white bg-dark card-hover'style='width:175px;margin-left:auto;margin-right:auto;margin-bottom:25px;align-items:center;'>";
			if(data[i]["Status"] == "Scheduled" && data[i]["AwayTeamMoneyLine"] != null){
					content += `<p style='margin-top:25px;' class='text-center'>${data[i]["HomeTeam"]} vs ${data[i]["AwayTeam"]}</p>`;
					content += `<form action="games/addgame/${data[i]["GameID"]}/${data[i]["StadiumID"]}/${data[i]["HomeTeam"]}/${data[i]["AwayTeam"]}" method="post">
    							<button type="submit" class='btn text-center' style='width:150px;'>Bet on Game</button>
								</form>`
			}else if(data[i]["Status"] == "InProgress"){
				content += `In Progress`;
				content += `<p>${data[i]["HomeTeamScore"]} vs ${data[i]["AwayTeamScore"]}</p>`;
			}else{
			content += `<p>${data[i]["HomeTeam"]} vs ${data[i]["AwayTeam"]}</p>`;
			}
			content += "</div>"
	}
	document.getElementById("games").innerHTML = content; 
	return 
}




async function gameResults(data){
	content = '';
	for(var i = 0; i < data.length; i++){
		content += "<div class='card text-white bg-dark'style='width:175px;margin-left:auto;margin-right:auto;margin-bottom:25px;align-items:center;display:'>";
			content += `<p style='margin-top:25px;'>${data[i]["HomeTeam"]} vs ${data[i]["AwayTeam"]}</p>`;
			content += `<p>${data[i]["HomeTeamScore"]} - ${data[i]["AwayTeamScore"]}</p>`;
		content += "</div>"
	}
	document.getElementById("games").innerHTML = content; 
	return
}
