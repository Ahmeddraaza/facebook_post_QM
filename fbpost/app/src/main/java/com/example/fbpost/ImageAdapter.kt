import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fbpost.FbPost
import com.example.fbpost.R
import com.example.fbpost.view.NewActivity
import com.squareup.picasso.Picasso

data class FbPost(
    val id: String,
    val content: String,
    val timestamp: String,
    val Image: String,
    val Link: String
)

class ImageAdapter(
    private val context: Context,
    private val imageUrlList: List<String>,
    private val fbPostList: List<FbPost>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fb_post, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = imageUrlList[position]
        val fbPost = fbPostList[position]
        Picasso.get().load(imageUrl).into(holder.imageView)

        holder.imageView.setOnClickListener {
            val onclickintent = Intent(context, NewActivity::class.java)
            onclickintent.putExtra("image_url", imageUrlList[position])
            onclickintent.putExtra("fb_post_link", fbPost.Link)
            context.startActivity(onclickintent)
        }

        holder.likeButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(fbPost.Link))
            context.startActivity(browserIntent)
        }

        holder.shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, fbPost.Link)
            context.startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    override fun getItemCount(): Int {
        return imageUrlList.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val likeButton: Button = itemView.findViewById(R.id.likeButton)
        val shareButton: Button = itemView.findViewById(R.id.shareButton)
    }
}
