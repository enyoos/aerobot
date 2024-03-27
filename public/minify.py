## Script to minify the js or the css

if __name__ == "__main__":
    import argparse

    parser = argparse.ArgumentParser()
    parser.add_argument( "-f", "--filename", type=str )

    args   = parser.parse_args()

    # read from the file 
    with open ( args.filename, "r", encoding="utf-8") as f :

        # TODO output to a test file ( out.js )
        # with open ( ) 
        print ( "\n".join(f.readlines()) )
