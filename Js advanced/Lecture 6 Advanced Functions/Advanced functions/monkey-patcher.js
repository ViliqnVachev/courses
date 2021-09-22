function solution(params) {
    let commands = {
        'upvote': () => { this.upvotes++; },
        'downvote': () => { this.downvotes++; },
        'score': () => {
            let totalVotes = this.downvotes + this.upvotes;
            let totalScore = this.upvotes - this.downvotes;
            let infaltionAmount = Math.ceil(Math.max(this.downvotes, this.upvotes) * 0.25);
            let infUpvotes = totalVotes > 50 ? this.upvotes + infaltionAmount : this.upvotes;
            let infDownvotes = totalVotes > 50 ? this.downvotes + infaltionAmount : this.downvotes;

            let raiting = 'new';
            if (totalVotes < 10) {
                raiting = 'new';
            } else if (this.upvotes / totalVotes > 0.66) {
                raiting = 'hot';
            } else if (this.downvotes <= this.upvotes && totalVotes > 100) {
                raiting = 'controversial';
            } else if (this.downvotes > this.upvotes) {
                raiting = 'unpopular';
            }
            return [infUpvotes, infDownvotes, totalScore, raiting];
        }
    }
    return commands[params]();

}

let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};
solution.call(post, 'upvote');
solution.call(post, 'downvote');
let score = solution.call(post, 'score'); // [127, 127, 0, 'controversial']
solution.call(post, 'downvote'); //…        // (executed 50 times)
score = solution.call(post, 'score');     // [139, 189, -50, 'unpopular']
