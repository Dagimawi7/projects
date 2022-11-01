from tkinter import *
import random


#Constants
GAME_WIDTH = 700
GAME_HEIGHT = 700
SPEED = 50 # the lower the number the faster the game 
SPACE_SIZE = 50
BODY_PARTS = 3 #  body parts of the snake when the game starts 
SNAKE_COLOR = "#00FF00" # can be changed with the color picker color number
FOOD_COLOR = "#FF0000"
BACKGROUND_COLOR ="#000000"


class Snake: # class created for snake object
    
    def __init__(self):
        self.body_size = BODY_PARTS # body size
        self.coordinates = [] # list of coordinates
        self.squares = [] # list of square grahphics
        
        for i in range(0, BODY_PARTS): # problem to fix
            # creates list of coordinates
           self.coordinates.append([0, 0]) # appends a new list and the coordinate 
            # each body part at the start of the game starts at 0,0 
            # so that the snake will appear in the top left corner

        for x, y in self.coordinates:
             # creates squares
            square = canvas.create_rectangle(x, y, x + SPACE_SIZE, y + SPACE_SIZE, fill=SNAKE_COLOR, tag="snake")
            self.squares.append(square)

        

class Food: # class created for Food object

    def __init__(self):# constructs a food object
        x = random.randint(0, (GAME_WIDTH / SPACE_SIZE ) - 1) * SPACE_SIZE # type: ignore # x coordinate converted to pixels
        x = random.randint(0, (GAME_HEIGHT / SPACE_SIZE ) - 1) * SPACE_SIZE # y coordinate converted to pixels

        self.coordinates = [x,y] # have the cordinates

        canvas.create_oval(x, y, x + SPACE_SIZE, y + SPACE_SIZE, fill=FOOD_COLOR, tag="food")# draws the red food oval obj

def next_turn(snake, food): # function created for next turn
    x, y = snake.coordinates[0]# head of the snake

    if direction == "up":
        y -= SPACE_SIZE # Snake moves one space up
    elif direction == "down":
        y += SPACE_SIZE # Snake moves one space down
    elif direction == "left":
        x -= SPACE_SIZE # Snake moves one space left
    elif direction == "right":
        x += SPACE_SIZE # Snake moves one space right

        snake.coordinates.insert(0, (x, y))# updates the coordinates for the head of the snake 
        #and x, y will be inserted in the new location 
 
        square = canvas.create_rectangle(x, y, x + SPACE_SIZE, y + SPACE_SIZE, fill=SNAKE_COLOR)
        # creating a new graphic for the head of the snake
        snake.squares.insert(0, square) # updates snakes list of squares

        del snake.coordinates[-1] # deleting the last body part of the snake

        canvas.delete(snake.squares[-1]) # updates the canvas

        del snake.squares[-1] # delets the list of squares


        window.after(SPEED, next_turn, snake, food)# next turn 

def change_direction(new_direction): # function create for change of direction 
    
    global direction
    
    if new_direction == 'left':
        if direction != 'right':
            direction = new_direction
        
    elif new_direction == 'right':
            if direction != 'right':
                direction = new_direction
                
    elif new_direction == 'up':
        if direction != 'left':
            direction = new_direction
            
    elif new_direction == 'down':
        if direction != 'up':
            direction = new_direction
            
    
            
    

def game_over(): # function created to check if game is over
    pass


window = Tk() # creatin window
window.title("snake game") # title of the window
window.resizable(False, False)# True you can resize the window with your mouse, false you can't

score = 0 # keeps score
direction = 'down'

label = Label(window, text = "score:{}".format(score), font=('Times',40))# a score lable(score:0)
label.pack()

canvas = Canvas(window, bg=BACKGROUND_COLOR, height=GAME_HEIGHT, width=GAME_WIDTH) # creats the big black board(canvas)
canvas.pack()

window.update() # updates the window, so it renders

# makes the canvas center when the game begins, those are dimesnsions
window_width = window.winfo_width()
window_height = window.winfo_height()
screen_width = window.winfo_screenwidth()
screen_height = window.winfo_screenheight()

x = int((screen_width / 2) - (window_width / 2)) # adjust the width postion of the window
y = int((screen_height / 2) - (window_height / 2)) # adjust the height postion of the window

window.geometry(f"{window_width}x{window_height}+{x}+{y}") # sets the geometery

# binding some keys for the snake 
window.bind('<Left>', lambda event: change_direction('left'))
window.bind('<Right>', lambda event: change_direction('right'))
window.bind('<Up>', lambda event: change_direction('up'))
window.bind('<Down>', lambda event: change_direction('Down'))

snake = Snake()
food = Food()

next_turn(snake, food)


window.mainloop()